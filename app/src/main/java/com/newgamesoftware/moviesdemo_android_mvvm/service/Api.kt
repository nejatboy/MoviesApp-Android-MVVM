package com.newgamesoftware.moviesdemo_android_mvvm.service

import com.newgamesoftware.moviesdemo_android_mvvm.model.Movie
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST("3/movie/now_playing?api_key={apiKey}&language={language}&page={page}")
    suspend fun fetchNowPlayingList(
        @Path("apiKey") apiKey: String,
        @Path("language") language: String,
        @Path("page") page: Int
    ) : ArrayList<Movie>


    @POST("3/movie/upcoming?api_key={apiKey}&language={language}&page={page}")
    suspend fun fetchIncomingList(
        @Path("apiKey") apiKey: String,
        @Path("language") language: String,
        @Path("page") page: Int
    ) : ArrayList<Movie>
}