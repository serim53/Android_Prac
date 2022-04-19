package com.example.pagingapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    fun getUser() : Flow<PagingData<User>> = GetUserUseCase().getUser().cachedIn(viewModelScope)
}