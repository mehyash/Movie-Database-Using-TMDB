package com.yash.imdbclone.repository

import com.yash.imdbclone.data.MovieListResponse
import com.yash.imdbclone.remote.MovieApi
import com.yash.imdbclone.utils.NetworkResult
import javax.inject.Inject

interface MovieRepository {

    suspend fun getMovieList():NetworkResult<MovieListResponse>

}