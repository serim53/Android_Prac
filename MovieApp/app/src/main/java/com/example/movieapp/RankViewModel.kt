package com.example.movieapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}