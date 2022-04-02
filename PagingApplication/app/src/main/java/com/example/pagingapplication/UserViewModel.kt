package com.example.pagingapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val users : MutableLiveData<PagingData<User>> = MutableLiveData()

    fun getUser() : LiveData<PagingData<User>> {
        viewModelScope.launch {
            users.postValue(GetUserUseCase().getUser().value ?: PagingData.empty())
        }
        return users
    }
}