package com.newgamesoftware.moviesdemo_android_mvvm.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.newgamesoftware.moviesdemo_android_mvvm.repository.BaseRepository
import com.newgamesoftware.moviesdemo_android_mvvm.repository.MovieRepository
import com.newgamesoftware.moviesdemo_android_mvvm.ui.home.HomeViewModel
import com.newgamesoftware.moviesdemo_android_mvvm.ui.home.top.TopViewModel


@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: BaseRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as MovieRepository) as T
            modelClass.isAssignableFrom(TopViewModel::class.java) -> TopViewModel(repository as MovieRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Fount")
        }
    }
}