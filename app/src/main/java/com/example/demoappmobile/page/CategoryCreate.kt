package com.example.demoappmobile.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.demoappmobile.viewmodel.category.CategoryFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCreateScreen(
    categoryFormViewModel: CategoryFormViewModel,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Create Category") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        CategoryCreateContent(
            modifier = Modifier.padding(innerPadding),
            navController,
            categoryFormViewModel
        )
    }
}

@Composable
fun CategoryCreateContent(
    modifier: Modifier,
    navController: NavController,
    categoryFormViewModel: CategoryFormViewModel
) {

    var id by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = id,
            onValueChange = { id = it },
            singleLine = true,
            label = { Text(text = "id") },
            placeholder = { Text(text = "Enter your id") },
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Numbers,
                    contentDescription = "Icon number"
                )
            },
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            singleLine = true,
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Enter your name") },
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon"
                )
            },
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                categoryFormViewModel.saveCategory(id.toInt(), name, {
                    navController.popBackStack()
                })
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Submit",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}