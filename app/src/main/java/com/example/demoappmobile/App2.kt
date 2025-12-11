package com.example.demoappmobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demoappmobile.page.LoginPage
import com.example.demoappmobile.viewmodel.auth.Auth

@Composable
fun App() {
    val authViewModel: Auth = viewModel()

    if (authViewModel.user == null) LoginPage()
    else {
        Scaffold { innerPadding ->
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
            }
        }
    }
}