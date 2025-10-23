package com.example.demoappmobile.entity

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("judul") var judul: String,
    var deskripsi: String,
    var poster: String
)
