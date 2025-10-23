package com.example.demoappmobile.components.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.demoappmobile.models.Movie

@Composable
fun MovieList(modifier: Modifier = Modifier, movies: List<Movie>, onMovieClick: (Int) -> Unit) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(movies) { movie ->
            MovieItem(movie = movie, onClick = { onMovieClick(movie.id) })
        }
    }

}

