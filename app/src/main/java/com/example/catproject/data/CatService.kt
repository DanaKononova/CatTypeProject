package com.example.catproject.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("images/search")
    fun getCat(@Query("Limit") limit: Int): Call<List<CatResponse>>
}

