package com.example.demoappmobile.entity

open class Person(var firstName: String, var lastName: String? = null) {
    open fun showInfo(): String {
        return lastName?.let { lName ->
            "$firstName $lName"
        } ?: firstName
    }
}