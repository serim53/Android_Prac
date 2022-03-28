package com.example.movieapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class MovieRepository(application: Application) {

    private val movieDao: MovieDao

    init {
        val db = AppDatabase.getInstance(application)
        movieDao = db!!.movieDao()
    }

    suspend fun getAll(): List<MovieEntity> {
        return movieDao.getAll()
    }

    suspend fun insert(movieEntity: MovieEntity) {
        movieDao.insert(movieEntity)
        // Log.d("insert_room", movieEntity.toString())
    }

    suspend fun delete(movieEntity: MovieEntity) {
        movieDao.delete(movieEntity)
    }

    suspend fun getMovies(): List<Movie> {
        return RetrofitInstance.service.getMovies().await()
    }
}