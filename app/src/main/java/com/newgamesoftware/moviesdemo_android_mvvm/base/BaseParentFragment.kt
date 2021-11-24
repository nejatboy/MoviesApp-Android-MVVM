package com.newgamesoftware.moviesdemo_android_mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.newgamesoftware.moviesdemo_android_mvvm.repository.BaseRepository
import com.newgamesoftware.moviesdemo_android_mvvm.service.RemoteDataSource


abstract class BaseParentFragment<VM: ViewModel, VB: ViewBinding, R: BaseRepository, A: BaseActivity>: BaseFragment<VB, A>() {

    protected val remoteDataSource = RemoteDataSource()
    protected lateinit var viewModel: VM


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
    }


    abstract fun getViewModel() : Class<VM>


    abstract fun getFragmentRepository() : R
}