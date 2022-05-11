package com.prography.composeapplication

import retrofit2.http.GET

interface GithubInfraService {

    @GET("users")
    suspend fun getUsers(): List<User>
}