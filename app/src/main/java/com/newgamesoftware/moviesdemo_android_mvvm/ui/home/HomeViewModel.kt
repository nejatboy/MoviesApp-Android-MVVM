package com.newgamesoftware.moviesdemo_android_mvvm.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newgamesoftware.moviesdemo_android_mvvm.model.Language
import com.newgamesoftware.moviesdemo_android_mvvm.model.Movie
import com.newgamesoftware.moviesdemo_android_mvvm.repository.MovieRepository
import com.newgamesoftware.moviesdemo_android_mvvm.service.Resource
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MovieRepository): ViewModel() {

    val movies = MutableLiveData<ArrayList<Movie>>()
    val error = MutableLiveData<String>()


    fun requestFetchIncomingList(page: Int, language: Language) {

        viewModelScope.launch {
            val result = repository.requestFetchUpComingList(page, language)

            val moviesResponseModel = (result as? Resource.Success)?.value ?: run {
                val failure = result as Resource.Failure
                error.postValue(failure.exception.localizedMessage)
                return@launch
            }

            movies.postValue(moviesResponseModel.movies)
        }
    }

}