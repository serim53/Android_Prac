package com.example.myapplication.data

import com.example.myapplication.data.entity.UserDto
import retrofit2.Call
import retrofit2.http.GET

interface GithubInfraService {
    @GET("/users")
    fun getUsers(): Call<List<UserDto>>
}