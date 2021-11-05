package com.doye.mutlipreviererlib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.doye.mutlipreviererlib.R


class SubViewerAdapter(): RecyclerView.Adapter<SubViewerAdapter.MainViewerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubViewerAdapter.MainViewerHolder {
        return MainViewerHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_sub_viewer, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SubViewerAdapter.MainViewerHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
      return  10
    }

    inner class MainViewerHolder(view: View):RecyclerView.ViewHolder(view){
        val tvTest = view.findViewById<TextView>(R.id.tvTest)
        fun bind(){
            tvTest.text = position.toString()

        }
    }

}