package com.example.lesson16.data

import retrofit2.http.GET

interface CatFactApi {
    @GET("fact")
    suspend fun getCatFact() : CatFactDto
}