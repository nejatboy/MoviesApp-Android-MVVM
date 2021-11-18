package com.newgamesoftware.moviesdemo_android_mvvm.repository

import com.newgamesoftware.moviesdemo_android_mvvm.model.Language
import com.newgamesoftware.moviesdemo_android_mvvm.service.Api

class MovieRepository(private val api: Api): BaseRepository() {


    suspend fun requestFetchIncomingList(page: Int, language: Language) {
        safeApiCall {
            api.fetchIncomingList(apiKey = apiKey, language = language.value, page = page)
        }
    }
}