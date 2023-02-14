package com.example.catproject.domain

import com.example.catproject.data.CatResponse

interface Repository {
    suspend fun getImage(typeKey:String): List<CatResponse>
}