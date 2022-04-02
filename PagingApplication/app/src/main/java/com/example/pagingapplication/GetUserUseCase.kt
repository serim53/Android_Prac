package com.example.pagingapplication

import androidx.lifecycle.LiveData
import androidx.paging.PagingData

class GetUserUseCase {

    val repository: GithubRepository = GithubRepositoryImpl()

    suspend fun getUser(): LiveData<PagingData<User>> = repository.getUsers()
}