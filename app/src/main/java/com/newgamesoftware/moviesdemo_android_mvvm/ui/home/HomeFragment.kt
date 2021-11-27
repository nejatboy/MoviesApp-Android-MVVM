package com.newgamesoftware.moviesdemo_android_mvvm.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseParentFragment
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.FragmentHomeBinding
import com.newgamesoftware.moviesdemo_android_mvvm.model.Language
import com.newgamesoftware.moviesdemo_android_mvvm.model.Movie
import com.newgamesoftware.moviesdemo_android_mvvm.repository.MovieRepository
import com.newgamesoftware.moviesdemo_android_mvvm.service.Api
import com.newgamesoftware.moviesdemo_android_mvvm.ui.MainActivity


class HomeFragment: BaseParentFragment<HomeViewModel, FragmentHomeBinding, MovieRepository, MainActivity>() {


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
        viewModel.error.observe(viewLifecycleOwner, ::observeError)

        request(page = 1)
    }


    private fun request(page: Int) {
        showProgress()
        viewModel.requestFetchIncomingList(page = page, language = Language.EN)
    }


    private fun observeMovies(movies: ArrayList<Movie>) {
        hideProgress()
        binding.recyclerViewHome.adapter().addMovies(newList = movies)
    }


    fun onItemMovieClicked(movie: Movie) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(movie)
        (parentFragment as NavHostFragment).navController.navigate(action)
        //Navigation.findNavController(requireView()).navigate(action)
    }


    private fun observeError(error: String) {
        showMessage(message = error)
    }
}