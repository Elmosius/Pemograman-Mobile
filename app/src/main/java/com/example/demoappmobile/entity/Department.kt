package com.example.demoappmobile.entity

data class Department(val id: String, var name: String) {
    override fun toString(): String {
        return name
    }
}