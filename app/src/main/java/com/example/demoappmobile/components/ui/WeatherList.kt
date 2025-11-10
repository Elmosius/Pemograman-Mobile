package com.example.demoappmobile.components.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.demoappmobile.models.Weather

@Composable
fun WeatherList(modifier: Modifier, data: List<Weather>, onWeatherClick: (Int) -> Unit) {
    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(data) { index, item ->
            val containerColor = if (index % 2 == 0) {
                Color.Cyan
            } else {
                Color.Magenta
            }
            WeatherItem(containerColor = containerColor, data = item, onItemClick = {
                onWeatherClick(item.id)
            })
        }
    }
}