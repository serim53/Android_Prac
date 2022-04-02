package com.example.pagingapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.*
import kotlinx.coroutines.flow.map
import retrofit2.await

class GithubRepositoryImpl() : GithubRepository{
    override suspend fun getUsers(): LiveData<PagingData<User>> =
        Pager(
            PagingConfig(pageSize = 20)
        ){
            PagingSource()
        }.flow.map { pagingData ->
            pagingData.map { it.toUser() }
        }.asLiveData()

}