package com.example.demoappmobile.ui.tablet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.demoappmobile.entity.Movie2
import com.example.demoappmobile.ui.component.MovieDetail
import com.example.demoappmobile.ui.component.MovieItem
import com.example.demoappmobile.viewmodel.movie.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    viewModel: Movie
) {
    val movies by viewModel.movies.collectAsState()
    val movie by viewModel.movie.collectAsState()
    var selectedMovie by remember { mutableStateOf<Movie2?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movies - Tablet View") }
            )
        }
    ) { padding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(movies) { movieItem ->
                    MovieItem(
                        movie = movieItem,
                        isSelected = selectedMovie?.id == movieItem.id,
                        onClick = {
                            selectedMovie = movieItem
                            viewModel.loadMovie(movieItem.id.toInt())
                        }
                    )
                }
            }

            VerticalDivider()

            Box(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxHeight()
                    .padding(24.dp)
            ) {
                if (selectedMovie != null) {
                    MovieDetail(
                        movie = movie,
                        isLoading = movie == null
                    )
                } else {
                    Text(
                        text = "Select a movie to view details",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}
