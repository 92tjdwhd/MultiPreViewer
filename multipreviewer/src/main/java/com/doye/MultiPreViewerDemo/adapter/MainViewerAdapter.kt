package com.doye.MultiPreViewerDemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.doye.MultiPreViewerDemo.R

class MainViewerAdapter(): RecyclerView.Adapter<MainViewerAdapter.MainViewerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewerAdapter.MainViewerHolder {
        return MainViewerHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_main_viewer, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewerAdapter.MainViewerHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
      return  4
    }

    inner class MainViewerHolder(view: View):RecyclerView.ViewHolder(view){
        val tvTest = view.findViewById<TextView>(R.id.tvTest)
        fun bind(){
            tvTest.text = position.toString()
        }
    }

}