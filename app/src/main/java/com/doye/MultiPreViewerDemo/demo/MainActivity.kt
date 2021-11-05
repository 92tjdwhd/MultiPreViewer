package com.doye.MultiPreViewerDemo.demo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.doye.mutlipreviererlib.MultiPreViewer

class MainActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        MultiPreViewer().show(supportFragmentManager,"")
    }
}