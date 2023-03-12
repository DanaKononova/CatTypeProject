package com.example.catproject.di

import com.example.catproject.data.RepositoryImpl
import com.example.catproject.domain.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun getRepository(impl: RepositoryImpl): Repository
}