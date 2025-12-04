package com.example.demoappmobile.service

import com.example.demoappmobile.entity.Movie2
import com.example.demoappmobile.entity.MyDepartment
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("get_all_departments_service.php")
    suspend fun getAllDepartments(): List<MyDepartment>

    @GET("movie_data.json")
    suspend fun getMovieData(): List<Movie2>

    @GET("m{id}.json")
    suspend fun getMovieDetail(
        @Path("id") id: Int
    ): Movie2
}