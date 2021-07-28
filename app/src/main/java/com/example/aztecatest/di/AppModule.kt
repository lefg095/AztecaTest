package com.example.aztecatest.di

import android.content.Context
import com.example.aztecatest.MyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplicacion(@ApplicationContext app: Context): MyApplication = app as MyApplication
}