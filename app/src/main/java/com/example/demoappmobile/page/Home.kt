package com.example.demoappmobile.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.demoappmobile.navigation.Route
import com.example.demoappmobile.viewmodel.auth.Auth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(authViewModel: Auth, navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Home")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome ${authViewModel.user?.email}")

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    authViewModel.signOut()
                }
            ) {
                Text(text = "Sign Out")
            }

            Button(
                onClick = {
                    navController.navigate(Route.CATEGORY_INDEX)
                }
            ) {
                Text(text = "Open Category Screen")
            }
        }
    }
}
