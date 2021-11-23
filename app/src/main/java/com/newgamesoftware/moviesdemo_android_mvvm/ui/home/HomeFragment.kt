package com.newgamesoftware.moviesdemo_android_mvvm.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseParentFragment
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.FragmentHomeBinding
import com.newgamesoftware.moviesdemo_android_mvvm.model.Language
import com.newgamesoftware.moviesdemo_android_mvvm.model.Movie
import com.newgamesoftware.moviesdemo_android_mvvm.repository.MovieRepository
import com.newgamesoftware.moviesdemo_android_mvvm.service.Api


class HomeFragment: BaseParentFragment<HomeViewModel, FragmentHomeBinding, MovieRepository>() {


    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }


    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


    override fun getFragmentRepository(): MovieRepository {
        val api = remoteDataSource.buildApi(Api::class.java)
        return MovieRepository(api)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewHome.adapter().apply {
            request = ::request
            onItemMovieClicked = ::onItemMovieClicked
        }

        viewModel.movies.observe(viewLifecycleOwner, ::observeMovies)

        request(page = 1)
    }


    private fun request(page: Int) {
        viewModel.requestFetchIncomingList(page = page, language = Language.EN)
    }


    private fun observeMovies(movies: ArrayList<Movie>) {
        binding.recyclerViewHome.adapter().addMovies(newList = movies)
    }


    private fun onItemMovieClicked(movie: Movie) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(movie)
        //val action = ActionOnlyNavDirections(R.id.action_homeFragment_to_detailFragment)
        Navigation.findNavController(requireView()).navigate(action)
    }
}