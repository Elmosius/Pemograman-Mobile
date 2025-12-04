package com.example.demoappmobile.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie2(
    @SerialName("id") var id: Int,
    @SerialName("title") var title: String,
    @SerialName("description") var description: String,
    @SerialName("cover") var poster: String
)
