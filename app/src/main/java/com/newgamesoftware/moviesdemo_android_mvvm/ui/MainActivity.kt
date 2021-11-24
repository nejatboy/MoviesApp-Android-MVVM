package com.newgamesoftware.moviesdemo_android_mvvm.ui

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.newgamesoftware.moviesdemo_android_mvvm.R
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseActivity
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.ActivityMainBinding
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.LayoutProgressBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun showProgress() {
        binding.progressView.root.visibility = View.VISIBLE
    }


    override fun hideProgress() {
        binding.progressView.root.visibility = View.INVISIBLE
    }
}