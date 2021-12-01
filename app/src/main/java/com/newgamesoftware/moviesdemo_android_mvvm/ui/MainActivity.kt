package com.newgamesoftware.moviesdemo_android_mvvm.ui

import android.os.Bundle
import android.view.View
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseActivity
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.ActivityMainBinding

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