package com.example.demoappmobile.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demoappmobile.ui.phone.DetailPage
import com.example.demoappmobile.ui.phone.HomePage
import com.example.demoappmobile.viewmodel.movie.Movie

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val movieViewModel: Movie = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomePage(
                viewModel = movieViewModel,
                onMovieClick = { movieId ->
                    navController.navigate("detail/$movieId")
                }
            )
        }
        composable(
            route = "detail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            DetailPage(
                viewModel = movieViewModel,
                movieId = movieId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
