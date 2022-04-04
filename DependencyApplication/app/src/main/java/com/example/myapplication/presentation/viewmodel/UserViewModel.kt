package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecase.GetUsersUseCase
import com.example.myapplication.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    val items: MutableLiveData<List<User>> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch {
            items.postValue(getUsersUseCase())
        }
    }

}