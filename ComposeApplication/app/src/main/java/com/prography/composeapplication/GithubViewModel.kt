package com.prography.composeapplication
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GithubViewModel : ViewModel(){

    val _userData: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val userData = _userData

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            _userData.value = RetrofitInstance.infraService.getUsers()
        }
    }
}