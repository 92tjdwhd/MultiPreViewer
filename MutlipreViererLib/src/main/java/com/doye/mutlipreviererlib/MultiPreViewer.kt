package com.doye.mutlipreviererlib

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.doye.mutlipreviererlib.adapter.MainViewerAdapter
import com.doye.mutlipreviererlib.adapter.SubViewerAdapter
import com.doye.mutlipreviererlib.databinding.DialogMultipreviewerBinding


class MultiPreViewer : DialogFragment() {

    private lateinit var binding : DialogMultipreviewerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Dialog)
    }

    @SuppressLint("WrongConstant")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogMultipreviewerBinding.inflate(inflater,container,false)
        binding.vp2MainViewer.adapter = MainViewerAdapter()
        binding.vp2MainViewer.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.rv2SubViewer.adapter = SubViewerAdapter()
        //binding.rv2SubViewer.layoutManager = LinearLayoutManager(binding.root.context, LinearLayout.HORIZONTAL, false)
        binding.rv2SubViewer.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.rv2SubViewer.offscreenPageLimit = 2
        val offsetPx = dpToPx(213,binding.root.context)
        binding.rv2SubViewer.setPadding(offsetPx, 0, offsetPx, 0)

        val width = binding.root.context.resources.displayMetrics.densityDpi
        val height = binding.root.context.resources.displayMetrics.widthPixels
        val pageMarginPx =dpToPx(10,binding.root.context)
        val marginTransformer = MarginPageTransformer(pageMarginPx)
        binding.rv2SubViewer.setPageTransformer(marginTransformer)
        binding.vp2MainViewer.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.rv2SubViewer.setCurrentItem(position,false)
            }
        })

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.run {
            val params = attributes
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.height = ViewGroup.LayoutParams.MATCH_PARENT
            params.dimAmount = 0.6f
            params.windowAnimations = -1
            attributes = params
            setBackgroundDrawableResource(android.R.color.black)
        }
      //  binding.rv2SubViewer.layoutManager?.scrollToPosition(3)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun dpToPx(dp:Int, context: Context):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),context.resources.displayMetrics).toInt()
    }
}