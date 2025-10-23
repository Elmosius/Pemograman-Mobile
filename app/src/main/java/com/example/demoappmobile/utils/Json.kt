package com.example.demoappmobile.utils

import android.content.Context
import com.example.demoappmobile.models.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun loadMovieData(context: Context): List<Movie> {
    val json = context.assets.open("data_film.json").bufferedReader().use { it.readText() }

    val type = object : TypeToken<List<Movie>>() {}.type
    return Gson().fromJson(json, type)
}