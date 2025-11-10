package com.example.demoappmobile.utils

import android.content.Context
import com.example.demoappmobile.models.Weather
import com.example.demoappmobile.models.WeatherJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun loadData(context: Context): List<Weather> {
    val json = context.assets.open("weather.json").bufferedReader().use {
        it.readText()
    }

    val type = object : TypeToken<WeatherJson>() {}.type

    return Gson().fromJson<WeatherJson>(json, type).data
}