package com.example.demoappmobile.entity

class Student(val studentId: String, firstName: String, lastName: String? = null) :
    Person(firstName, lastName) {
    override fun showInfo(): String {
        return studentId + (lastName?.let { e ->
            "$firstName $e"
        } ?: " $firstName")
    }
}