package com.newgamesoftware.moviesdemo_android_mvvm.repository

import com.newgamesoftware.moviesdemo_android_mvvm.service.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    val apiKey = "d53aec0276d4b68b29114b8ead2b66fc"


    suspend fun <T> safeApiCall(apiCall: suspend  () -> T) : Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            }

            catch (throwable: Throwable) {
                when(throwable) {
                    is HttpException -> {
                        Resource.Failure(
                            isNetworkError = false,
                            errorCode = throwable.code(),
                            errorBody = throwable.response()?.errorBody()
                        )
                    }

                    else -> {
                        Resource.Failure(isNetworkError = true, errorCode = null, errorBody = null)
                    }
                }
            }
        }

    }
}