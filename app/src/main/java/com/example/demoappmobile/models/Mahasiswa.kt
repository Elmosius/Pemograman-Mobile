package com.example.demoappmobile.models

data class Mahasiswa(
    val id: String = java.util.UUID.randomUUID().toString(),
    val nrp: String,
    val nama: String,
    val alamat: String,
    val prodi: String,
)

