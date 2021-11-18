package com.newgamesoftware.moviesdemo_android_mvvm.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newgamesoftware.moviesdemo_android_mvvm.R
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseFragment

class DetailFragment: BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}