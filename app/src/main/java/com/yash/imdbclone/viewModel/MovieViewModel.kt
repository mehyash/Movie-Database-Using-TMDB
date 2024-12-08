package com.yash.imdbclone.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.viewModelScope
import com.yash.imdbclone.data.MovieListResponse
import com.yash.imdbclone.repository.MovieRepository
import com.yash.imdbclone.repository.MovieRepositoryImpl
import com.yash.imdbclone.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repositoryImpl: MovieRepositoryImpl):ViewModel(){
    private val _movielistLiveData=MutableLiveData<NetworkResult<MovieListResponse>>()
    val movieListLiveData:LiveData<NetworkResult<MovieListResponse>>
        get()=_movielistLiveData

    fun getMovielist(){
        viewModelScope.launch{
            val response=repositoryImpl.getMovieList()
            _movielistLiveData.value=response
            Log.d("D","$response")
        }
    }
}