package com.example.catproject.data

import com.example.catproject.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RepositoryImpl: Repository {
    override suspend fun getImage(typeKey: String): List<CatResponse> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CatService::class.java)
        return withContext(Dispatchers.IO) {
            service.getCat(typeKey).execute().body() ?: throw Exception()
        }
    }
}