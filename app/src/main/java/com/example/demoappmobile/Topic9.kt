package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoappmobile.entity.Movie
import com.example.demoappmobile.page.MovieMainPage
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class Topic9 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                MovieMainPage()
            }
        }
    }
}


@Composable
fun MainContent(modifier: Modifier = Modifier, movies: List<Movie>) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(movies) { movie ->
            Item(movie = movie)
        }
    }

}

@Composable
fun Item(movie: Movie) {
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)
        ) {
            Text(
                text = movie.judul,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 8.dp),
                fontWeight = FontWeight.Bold
            )

            Text(
                text = movie.deskripsi,
                modifier = Modifier
                    .padding(top = 0.dp, start = 15.dp, end = 15.dp, bottom = 8.dp),
                fontStyle = FontStyle.Italic
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    DemoAppMobileTheme {
        MovieMainPage()
    }
}