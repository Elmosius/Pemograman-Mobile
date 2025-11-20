package com.example.demoappmobile.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyDepartment(
    @SerialName("id") var id: String,
    @SerialName("name") var name: String
)
