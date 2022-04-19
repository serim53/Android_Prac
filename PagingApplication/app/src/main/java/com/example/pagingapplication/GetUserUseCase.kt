package com.example.pagingapplication

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class GetUserUseCase {
    val repository: GithubRepository = GithubRepositoryImpl()

    fun getUser(): Flow<PagingData<User>> = repository.getUsers()
}