package com.newgamesoftware.moviesdemo_android_mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.newgamesoftware.moviesdemo_android_mvvm.ui.detail.DetailFragmentArgs

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<VB: ViewBinding, A: BaseActivity>: Fragment() {

    protected lateinit var binding: VB


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = getFragmentBinding(inflater, container)
        return binding.root
    }


    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) : VB


    protected fun activity() : A {
        return activity as A
    }


    protected fun showProgress() {
        activity().showProgress()
    }


    protected fun hideProgress() {
        activity().hideProgress()
    }


    protected fun showMessage(message: String) = activity().showMessage(message)
}