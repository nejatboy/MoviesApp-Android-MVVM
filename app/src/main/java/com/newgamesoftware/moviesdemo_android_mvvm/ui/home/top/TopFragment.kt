package com.newgamesoftware.moviesdemo_android_mvvm.ui.home.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseParentFragment
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.FragmentTopBinding
import com.newgamesoftware.moviesdemo_android_mvvm.model.Language
import com.newgamesoftware.moviesdemo_android_mvvm.model.Movie
import com.newgamesoftware.moviesdemo_android_mvvm.repository.MovieRepository
import com.newgamesoftware.moviesdemo_android_mvvm.service.Api
import com.newgamesoftware.moviesdemo_android_mvvm.ui.MainActivity
import com.newgamesoftware.moviesdemo_android_mvvm.ui.home.HomeFragment
import com.newgamesoftware.moviesdemo_android_mvvm.ui.home.HomeFragmentDirections


class TopFragment: BaseParentFragment<TopViewModel, FragmentTopBinding, MovieRepository, MainActivity>() {


    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentTopBinding {
        return FragmentTopBinding.inflate(inflater, container, false)
    }

    override fun getViewModel(): Class<TopViewModel> {
        return TopViewModel::class.java
    }

    override fun getFragmentRepository(): MovieRepository {
        val api = remoteDataSource.buildApi(Api::class.java)
        return MovieRepository(api)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewTop.adapter().request = ::request
        binding.recyclerViewTop.adapter().onItemMovieClicked = ::onItemMovieClicked

        viewModel.movies.observe(viewLifecycleOwner, ::observeMovies)

        request(page = 1)
    }


    private fun request(page: Int) {
        viewModel.requestFetchNowPlayingList(page = page, language = Language.EN)
    }


    private fun observeMovies(movies: ArrayList<Movie>) {
        binding.recyclerViewTop.adapter().addMovies(newList = movies)
    }


    private fun onItemMovieClicked(movie: Movie) {
        (parentFragment?.parentFragment as? HomeFragment)?.onItemMovieClicked(movie)
    }
}