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

abstract class BaseFragment<VM: ViewModel, VB: ViewBinding, R: BaseRepository>: Fragment() {

    protected lateinit var binding: VB
    protected val remoteDataSource = RemoteDataSource()
    protected lateinit var viewModel: VM


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getFragmentBinding(inflater, container)

        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())

        return binding.root
    }


    abstract fun getViewModel() : Class<VM>


    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) : VB


    abstract fun getFragmentRepository() : R
}