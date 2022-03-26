package com.example.movieapp
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("/films")
    fun getMovies(): Call<List<Movie>>
}