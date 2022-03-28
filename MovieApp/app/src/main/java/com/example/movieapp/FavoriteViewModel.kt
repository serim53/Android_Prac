package com.example.movieapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// repository에서 application context 필요
// => ViewModel(x) AndroidViewModel(o) 상속

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository(application)

    private var items : MutableLiveData<List<MovieEntity>> = MutableLiveData()

    fun getAll(): LiveData<List<MovieEntity>> {
        viewModelScope.launch {
            items.postValue(repository.getAll())
        }
        return items
    }

    fun delete(movieEntity: MovieEntity) {
        viewModelScope.launch {
            repository.delete(movieEntity)
        }
    }
}