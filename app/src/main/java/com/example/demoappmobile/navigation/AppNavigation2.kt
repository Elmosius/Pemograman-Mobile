package com.example.demoappmobile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demoappmobile.page.CategoryCreateScreen
import com.example.demoappmobile.page.CategoryIndexScreen
import com.example.demoappmobile.page.HomeScreen
import com.example.demoappmobile.viewmodel.auth.Auth
import com.example.demoappmobile.viewmodel.category.CategoryFormViewModel
import com.example.demoappmobile.viewmodel.category.CategoryViewModel

@Composable
fun AppNavigation2(authViewModel: Auth) {

    val categoryViewModel: CategoryViewModel = viewModel()
    val categoryFormViewModel: CategoryFormViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.HOME) {
        composable("home") {
            HomeScreen(authViewModel, navController)
        }
        composable(route = Route.CATEGORY_INDEX) {
            CategoryIndexScreen(
                categoryViewModel.categories.collectAsState().value,
                navController,
                onBackClick = {
                    navController.popBackStack()
                })
        }
        composable(route = Route.CATEGORY_CREATE) {
            CategoryCreateScreen(categoryFormViewModel, navController)
        }

    }
}
