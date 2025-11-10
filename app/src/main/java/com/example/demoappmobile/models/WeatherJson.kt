package com.example.demoappmobile.models

data class WeatherJson(
    var status: String,
    var message: String,
    var data: List<Weather>
)
