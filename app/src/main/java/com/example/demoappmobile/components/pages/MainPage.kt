package com.example.demoappmobile.components.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.demoappmobile.components.ui.TopBar
import com.example.demoappmobile.components.ui.WeatherList
import com.example.demoappmobile.models.Weather

@Composable
fun MainPage(data: List<Weather>, onWeatherClick: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopBar(title = "Quiz01", color = Color.Gray, isBack = false)
        }
    ) { innerPadding ->
        WeatherList(
            modifier = Modifier.padding(innerPadding),
            data = data,
            onWeatherClick = onWeatherClick
        )
    }
}
