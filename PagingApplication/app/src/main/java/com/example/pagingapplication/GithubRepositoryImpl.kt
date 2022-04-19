package com.example.pagingapplication
import androidx.paging.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GithubRepositoryImpl : GithubRepository{
    override fun getUsers(): Flow<PagingData<User>> =
        Pager(
            PagingConfig(pageSize = 20)
        ){
            PagingSource()
            // cachedIn은 viewmodel에서 사용하는 것이 가장 좋음
            // }.flow.cachedIn(CoroutineScope(Dispatchers.IO)).map { pagingData ->
        }.flow.map { pagingData ->
            pagingData.map { it.toUser() }
        }
}