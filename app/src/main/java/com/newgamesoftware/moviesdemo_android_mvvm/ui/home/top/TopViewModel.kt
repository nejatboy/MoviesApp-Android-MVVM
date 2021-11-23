package com.newgamesoftware.moviesdemo_android_mvvm.ui.home.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newgamesoftware.moviesdemo_android_mvvm.model.Language
import com.newgamesoftware.moviesdemo_android_mvvm.model.Movie
import com.newgamesoftware.moviesdemo_android_mvvm.repository.MovieRepository
import com.newgamesoftware.moviesdemo_android_mvvm.service.Resource
import kotlinx.coroutines.launch

class TopViewModel(private val repository: MovieRepository): ViewModel() {

    val movies = MutableLiveData<ArrayList<Movie>>()


    fun requestFetchNowPlayingList(page: Int, language: Language) {

        viewModelScope.launch {
            val result = repository.requestFetchNowPlayingList(page, language)

            val moviesResponseModel = (result as? Resource.Success)?.value ?: run {
                val error = result as Resource.Failure
                return@launch
            }

            movies.postValue(moviesResponseModel.movies)
        }
    }
}