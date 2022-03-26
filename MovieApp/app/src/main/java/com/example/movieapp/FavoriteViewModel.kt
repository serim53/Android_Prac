package com.example.movieapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

// repository에서 application context 필요
// => ViewModel(x) AndroidViewModel(o) 상속

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository(application)
    private val items = repository.getAll()

    fun getAll(): LiveData<List<MovieEntity>> {
        return items
    }

    fun insert(movieEntity: MovieEntity) {
        repository.insert(movieEntity)
    }

    fun delete(movieEntity: MovieEntity) {
        repository.delete(movieEntity)
    }
}