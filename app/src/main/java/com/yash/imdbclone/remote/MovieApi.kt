package com.yash.imdbclone.remote

import com.yash.imdbclone.data.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("3/movie/now_playing?page=4")
    suspend fun getMovieList():Response<MovieListResponse>

}