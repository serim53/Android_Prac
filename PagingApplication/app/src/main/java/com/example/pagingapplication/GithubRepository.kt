package com.example.pagingapplication

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    fun getUsers(): Flow<PagingData<User>>
}