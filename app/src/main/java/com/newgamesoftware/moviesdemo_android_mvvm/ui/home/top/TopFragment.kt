package com.newgamesoftware.moviesdemo_android_mvvm.ui.home.top

import android.view.LayoutInflater
import android.view.ViewGroup
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseChildFragment
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.FragmentTopBinding

class TopFragment: BaseChildFragment<FragmentTopBinding>() {


    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentTopBinding {
        return FragmentTopBinding.inflate(inflater, container, false)
    }
}