package com.doye.MultiPreViewerDemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewpager2.widget.ViewPager2
import com.doye.MultiPreViewerDemo.adapter.MainViewerAdapter
import com.doye.MultiPreViewerDemo.databinding.DialogMultipreviewerBinding

 class MultiPreViewer : DialogFragment() {

    private lateinit var binding : DialogMultipreviewerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogMultipreviewerBinding.inflate(inflater,container,false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vp2MainViewer.adapter = MainViewerAdapter()
        binding.vp2MainViewer.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}