package com.example.myapplication.di

import com.example.myapplication.data.GithubInfraService
import com.example.myapplication.data.repository.UserRepositoryImpl
import com.example.myapplication.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(githubInfraService: GithubInfraService): UserRepository
    = UserRepositoryImpl(githubInfraService)

}