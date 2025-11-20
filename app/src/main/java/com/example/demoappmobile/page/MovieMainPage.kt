package com.example.demoappmobile.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.demoappmobile.MainContent
import com.example.demoappmobile.utils.loadMovieData2

@Composable
fun MovieMainPage() {
    Scaffold(
        topBar = {
            MovieTopBar()
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        MainContent(
            modifier = Modifier.padding(innerPadding),
            loadMovieData2(LocalContext.current, "data_film.json")
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopBar() {
    TopAppBar(
        title = {
            Text(text = "Movie App")
        }
    )
}