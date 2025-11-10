package com.example.demoappmobile.models

import com.google.gson.annotations.SerializedName

data class Weather(
    var id: Int,
    var kota: String,
    var provinsi: String,
    var suhu: Int,
    var kelembapan: Int,
    var kondisi: String,
    @SerializedName("kecepatan_angin") var kecepatanAngin: Int,
    @SerializedName("arah_angin") var arahAngin: String
)
