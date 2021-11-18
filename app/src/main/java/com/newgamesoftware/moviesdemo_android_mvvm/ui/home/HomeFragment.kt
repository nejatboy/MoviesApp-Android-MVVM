package com.newgamesoftware.moviesdemo_android_mvvm.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseFragment
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.FragmentHomeBinding
import com.newgamesoftware.moviesdemo_android_mvvm.repository.MovieRepository
import com.newgamesoftware.moviesdemo_android_mvvm.service.Api

class HomeFragment: BaseFragment<HomeViewModel, FragmentHomeBinding, MovieRepository>() {


    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }


    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


    override fun getFragmentRepository(): MovieRepository {
        return MovieRepository(remoteDataSource.buildApi(Api::class.java))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}