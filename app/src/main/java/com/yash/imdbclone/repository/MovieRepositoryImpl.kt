package com.yash.imdbclone.repository

import com.yash.imdbclone.data.MovieListResponse
import com.yash.imdbclone.remote.MovieApi
import com.yash.imdbclone.utils.NetworkResult
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieApi) : MovieRepository {
    override suspend fun getMovieList(): NetworkResult<MovieListResponse> {
        return try {
            val response = api.getMovieList()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    NetworkResult.Success(body)
                } else {
                    NetworkResult.Failed("Response body is null")
                }
            } else {
                NetworkResult.Failed(response.message().toString())
            }
        } catch (e: Exception) {
            NetworkResult.Failed(e.message.toString())
        }
    }
}