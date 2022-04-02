package com.example.pagingapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("/users")
    fun getUser(
        @Query("page") page: Int = 1
    ) : Call<List<UserEntity>>
}