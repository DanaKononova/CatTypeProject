package com.example.catproject.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

interface CatService {
    @GET("images/search")
    fun getCat(@Query("breed_ids") breed: String): Call<List<CatResponse>>
}

