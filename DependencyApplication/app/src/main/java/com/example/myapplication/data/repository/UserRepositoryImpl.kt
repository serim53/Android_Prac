package com.example.myapplication.data.repository

import com.example.myapplication.data.GithubInfraService
import com.example.myapplication.domain.model.User
import com.example.myapplication.domain.repository.UserRepository
import com.example.myapplication.toUser
import retrofit2.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val githubInfraService: GithubInfraService
): UserRepository {
    override suspend fun getUser(): List<User> {
        return githubInfraService.getUsers().await().map { it.toUser() }
    }
}