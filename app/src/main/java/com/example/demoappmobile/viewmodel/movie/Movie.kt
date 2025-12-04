package com.example.demoappmobile.viewmodel.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoappmobile.entity.Movie2
import com.example.demoappmobile.service.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Movie : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie2>>(emptyList())
    private val _movie = MutableStateFlow<Movie2?>(null)
    val movies = _movies.asStateFlow()
    val movie = _movie.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovie(id: Int) {
        viewModelScope.launch {
            val res = ApiClient.instance.getMovieDetail(id)
            _movie.value = res
        }
    }

    fun loadMovies() {
        viewModelScope.launch {
            val res = ApiClient.instance.getMovieData()
            _movies.value = res
        }
    }
}