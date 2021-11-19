package com.newgamesoftware.moviesdemo_android_mvvm.service


import com.newgamesoftware.moviesdemo_android_mvvm.model.MoviesResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("3/movie/now_playing")
    suspend fun fetchNowPlayingList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ) : MoviesResponseModel


    @GET("3/movie/upcoming")
    suspend fun fetchUpComingList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ) : MoviesResponseModel
}