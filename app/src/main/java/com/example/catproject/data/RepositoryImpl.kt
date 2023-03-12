package com.example.catproject.data

import com.example.catproject.di.NetworkModule
import com.example.catproject.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: CatService
) : Repository {
    override suspend fun getImage(typeKey: String): List<CatResponse> {
        return withContext(Dispatchers.IO) {
            service.getCat(typeKey).execute().body() ?: throw Exception()
        }
    }
}