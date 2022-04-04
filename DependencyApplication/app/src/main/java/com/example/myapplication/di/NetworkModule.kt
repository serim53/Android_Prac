package com.example.myapplication.di

import com.example.myapplication.data.GithubInfraService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Provides
    @Singleton
    fun providesInfraService(retrofit: Retrofit): GithubInfraService =
        retrofit.create(GithubInfraService::class.java)

    companion object {
        private const val BASE_URL = "https://api.github.com"
    }

}