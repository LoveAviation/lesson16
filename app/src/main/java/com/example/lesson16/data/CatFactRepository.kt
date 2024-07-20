package com.example.lesson16.data

import com.example.lesson16.entity.CatFact
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CatFactRepository @Inject constructor(){
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(CatFactApi::class.java)


    suspend fun getCatFact(): CatFact{
        return api.getCatFact()
    }
}