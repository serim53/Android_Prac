package com.example.movieapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// repository에서 application context 필요
// => ViewModel(x) AndroidViewModel(o) 상속

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository(application)

    var items = repository.getAll().stateIn(
        viewModelScope, SharingStarted.Lazily, listOf()
    ).map { data -> data.map { Movie(it.title, it.image, it.description) } }

    fun delete(movieEntity: MovieEntity) {
        viewModelScope.launch {
            repository.delete(movieEntity)
        }
    }
}