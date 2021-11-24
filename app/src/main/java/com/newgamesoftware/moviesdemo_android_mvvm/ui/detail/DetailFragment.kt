package com.newgamesoftware.moviesdemo_android_mvvm.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newgamesoftware.moviesdemo_android_mvvm.base.BaseChildFragment
import com.newgamesoftware.moviesdemo_android_mvvm.databinding.FragmentDetailBinding
import com.newgamesoftware.moviesdemo_android_mvvm.model.Movie
import com.newgamesoftware.moviesdemo_android_mvvm.ui.MainActivity
import com.newgamesoftware.moviesdemo_android_mvvm.util.loadUrl


class DetailFragment: BaseChildFragment<FragmentDetailBinding, MainActivity>() {


    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindMovie()
    }


    private fun bindMovie() {
        val arguments = arguments ?: return
        val movie = DetailFragmentArgs.fromBundle(arguments).movie

        binding.movie = movie

        /*binding.imageView.loadUrl(movie.getImageUrl(isPosterPath = false))
        binding.layoutImdb.textViewPoint.text = "${movie.voteAverage}/10"
        binding.layoutImdb.textViewDate.text = movie.releaseDate
        binding.textViewTitle.text = movie.getTitle
        binding.textViewDescription.text = movie.overview*/
    }
}