package com.example.pagingapplication

import androidx.lifecycle.LiveData
import androidx.paging.PagingData

interface GithubRepository {
    suspend fun getUsers(): LiveData<PagingData<User>>

//    companion object {
//
//    }
}