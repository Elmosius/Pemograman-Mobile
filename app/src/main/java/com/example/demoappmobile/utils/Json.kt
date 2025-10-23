package com.example.demoappmobile.utils

import android.content.Context
import com.example.demoappmobile.entity.Movie
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

fun loadMovieData(context: Context): List<Movie> {
    val json = context.assets.open("data_film.json").bufferedReader().use { it.readText() }

    val type = object : TypeToken<List<Movie>>() {}.type
    return Gson().fromJson(json, type)
}