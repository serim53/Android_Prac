package com.example.movieapp

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class MovieRepository(application: Application) {

    private val movieDao: MovieDao
    private val movieList: LiveData<List<MovieEntity>>

    init {
        val db = AppDatabase.getInstance(application)
        movieDao = db!!.movieDao()
        movieList = db.movieDao().getAll()
    }

    fun getAll(): LiveData<List<MovieEntity>> {
        return movieDao.getAll()
    }

    fun insert(movieEntity: MovieEntity) {
        movieDao.insert(movieEntity)
    }

    fun delete(movieEntity: MovieEntity) {
        movieDao.delete(movieEntity)
    }

    suspend fun getMovies(): List<Movie> = withContext(Dispatchers.IO){
        RetrofitInstance.service.getMovies().await()
    }
}