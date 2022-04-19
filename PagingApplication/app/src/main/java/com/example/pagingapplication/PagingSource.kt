package com.example.pagingapplication

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.await
import java.lang.Exception

class PagingSource: PagingSource<Int, UserEntity>() {
    override fun getRefreshKey(state: PagingState<Int, UserEntity>): Int? {
        // 가장 가까운 키를 찾아서 페이지를 관리함
        return state.anchorPosition?.let { anchorPosition ->
            state.closestItemToPosition(anchorPosition)?.id
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserEntity> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = RetrofitInstance.githubService.getUser(nextPageNumber).await()
            return LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}