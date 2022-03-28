package com.example.movieapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class RankViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepository(application)
    val myResponse : MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch {
            val response = repository.getMovies()
            myResponse.postValue(response)
        }
    }

    fun insert(movie: Movie) {
        viewModelScope.launch {
            repository.insert(MovieEntity(movie.title, movie.image, movie.description))
        }
    }

    fun delete(movie: Movie) {
        viewModelScope.launch {
            repository.delete(MovieEntity(movie.title, movie.image, movie.description))
        }
    }
}