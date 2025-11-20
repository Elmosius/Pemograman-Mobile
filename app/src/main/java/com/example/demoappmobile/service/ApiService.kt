package com.example.demoappmobile.service

import com.example.demoappmobile.entity.MyDepartment
import retrofit2.http.GET


interface ApiService {
    @GET("get_all_departments_service.php")
    suspend fun getAllDepartments(): List<MyDepartment>
}