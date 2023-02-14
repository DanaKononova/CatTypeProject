package com.example.catproject.data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class CatResponse(
    @SerializedName("url") val imageUrl: String? = null
)