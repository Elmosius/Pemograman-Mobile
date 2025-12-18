package com.example.demoappmobile

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demoappmobile.navigation.AppNavigation2
import com.example.demoappmobile.page.LoginPage
import com.example.demoappmobile.viewmodel.auth.Auth

@Composable
fun App() {
    val authViewModel: Auth = viewModel()

    if (authViewModel.user == null) LoginPage()
    else {
        AppNavigation2(authViewModel)
    }
}