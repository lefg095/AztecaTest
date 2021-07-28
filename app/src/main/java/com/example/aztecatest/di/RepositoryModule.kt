package com.example.aztecatest.di

import com.example.aztecatest.model.api.ApiService
import com.example.aztecatest.model.repository.implentation.PersonajeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepositor(apiService: ApiService) = PersonajeRepository(apiService)
}