package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoappmobile.entity.Movie
import com.example.demoappmobile.page.MovieMainPage
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class Topic6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                    Column(
//                        modifier = Modifier.padding(innerPadding)
//                    ) {
//                        CategoryLazyRow()
//                        MovieList()
//                    }
//
//                }
                
                MovieMainPage()
            }
        }
    }
}

@Composable
private fun CategoryLazyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier
    ) {
        items(10) { item ->
            Text(
                text = "Category #$item",
                modifier = Modifier
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun ItemLazyColumn(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(20) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .background(
                        Color(0xff29b7ff)
                    ),
            ) {

                Text(
                    text = "Item : $item",
                    modifier = Modifier
                        .padding(16.dp)
                )

            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}


@Composable
fun MovieList(modifier: Modifier = Modifier, movies: List<Movie>) {
//    val movies = listOf(
//        Movie(
//            "Inception",
//            "Seorang pencuri yang memiliki kemampuan untuk memasuki mimpi orang lain diberikan tugas terakhir untuk menanamkan ide di pikiran targetnya.",
//            "https://image.tmdb.org/t/p/w500/inception.jpg"
//        ),
//        Movie(
//            "The Dark Knight",
//            "Batman menghadapi Joker, seorang penjahat psikopat yang ingin membuktikan bahwa semua orang bisa menjadi jahat.",
//            "https://image.tmdb.org/t/p/w500/dark_knight.jpg"
//        ),
//        Movie(
//            "Interstellar",
//            "Sekelompok penjelajah luar angkasa berangkat melalui lubang cacing untuk mencari tempat baru bagi umat manusia.",
//            "https://image.tmdb.org/t/p/w500/interstellar.jpg"
//        ),
//        Movie(
//            "Avengers: Endgame",
//            "Para Avengers bersatu sekali lagi untuk membalikkan kehancuran yang disebabkan oleh Thanos.",
//            "https://image.tmdb.org/t/p/w500/endgame.jpg"
//        ),
//        Movie(
//            "Parasite",
//            "Keluarga miskin menyusup ke rumah keluarga kaya dengan berpura-pura menjadi pekerja profesional.",
//            "https://image.tmdb.org/t/p/w500/parasite.jpg"
//        ),
//        Movie(
//            "Spider-Man: No Way Home",
//            "Peter Parker meminta bantuan Doctor Strange untuk membuat orang melupakan identitas rahasianya, tapi sesuatu berjalan salah.",
//            "https://image.tmdb.org/t/p/w500/spiderman_no_way_home.jpg"
//        ),
//        Movie(
//            "The Matrix",
//            "Seorang hacker menemukan kenyataan bahwa dunia yang ia tinggali hanyalah simulasi buatan mesin.",
//            "https://image.tmdb.org/t/p/w500/matrix.jpg"
//        ),
//        Movie(
//            "Joker",
//            "Kisah asal-usul Arthur Fleck, seorang komedian gagal yang berubah menjadi kriminal gila bernama Joker.",
//            "https://image.tmdb.org/t/p/w500/joker.jpg"
//        ),
//        Movie(
//            "Guardians of the Galaxy",
//            "Sekelompok penjahat luar angkasa harus bekerja sama untuk menyelamatkan galaksi dari kehancuran.",
//            "https://image.tmdb.org/t/p/w500/guardians.jpg"
//        ),
//        Movie(
//            "The Shawshank Redemption",
//            "Seorang pria yang dipenjara karena kejahatan yang tidak dilakukannya membangun harapan dan persahabatan di balik jeruji besi.",
//            "https://image.tmdb.org/t/p/w500/shawshank.jpg"
//        )
//    )

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(movies) { movie ->
            MovieItem(movie = movie)
        }
    }

}

@Composable
fun MovieItem(movie: Movie) {
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
fun GreetingPreview5() {
    DemoAppMobileTheme {
//        MovieList()
    }
}
