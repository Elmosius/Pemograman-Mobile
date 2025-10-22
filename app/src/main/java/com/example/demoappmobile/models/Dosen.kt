package com.example.demoappmobile.models

data class Dosen(
    val id: String = java.util.UUID.randomUUID().toString(),
    val nik: String,
    val nama: String,
    val alamat: String,
    val prodi: String,
)

