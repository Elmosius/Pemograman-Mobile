package com.example.demoappmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoappmobile.components.pages.DosenPage
import com.example.demoappmobile.components.pages.HomePage
import com.example.demoappmobile.components.pages.MahasiswaPage
import com.example.demoappmobile.components.ui.TopBar
import com.example.demoappmobile.enum.Route
import com.example.demoappmobile.ui.theme.DemoAppMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAppMobileTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    var route by remember { mutableStateOf(Route.HOME) }

    val title = when (route) {
        Route.DOSEN -> "Data Dosen"
        Route.MAHASISWA -> "Data Mahasiswa"
        else -> "Data Mahasiswa & Dosen"
    }

    val showBack = route != Route.HOME

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = title,
                showBack = showBack,
                onBackClick = { route = Route.HOME }
            )
        }
    ) { innerPadding ->
        when (route) {
            Route.DOSEN -> {
                DosenPage(modifier = Modifier.padding(innerPadding))
            }

            Route.MAHASISWA -> {
                MahasiswaPage(modifier = Modifier.padding(innerPadding))
            }

            Route.HOME -> {
                HomePage(
                    onDosenClick = { route = Route.DOSEN },
                    onMahasiswaClick = { route = Route.MAHASISWA }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoAppMobileTheme {
        MainContent()
    }
}