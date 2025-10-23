package com.example.demoappmobile.components.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.demoappmobile.components.ui.MovieList
import com.example.demoappmobile.utils.loadMovieData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(onMovieClick: (Int) -> Unit) {
    val context = LocalContext.current
    val movies = loadMovieData(context)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movie List") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        MovieList(
            modifier = Modifier.padding(innerPadding),
            movies = movies,
            onMovieClick = onMovieClick
        )
    }
}