package com.example.demoappmobile

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demoappmobile.navigation.AppNavigation
import com.example.demoappmobile.ui.tablet.HomePage
import com.example.demoappmobile.viewmodel.movie.Movie

@Composable
fun App(windowSizeClass: WindowSizeClass) {
    val viewModel: Movie = viewModel()
    val width = windowSizeClass.widthSizeClass

    when (width) {
        WindowWidthSizeClass.Compact -> {
            AppNavigation()
        }

        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            HomePage(viewModel)
        }
    }
}