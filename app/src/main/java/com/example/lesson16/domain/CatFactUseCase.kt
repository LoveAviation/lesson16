package com.example.lesson16.domain

import com.example.lesson16.data.CatFactRepository
import com.example.lesson16.entity.CatFact
import javax.inject.Inject

class CatFactUseCase @Inject constructor(private val repository: CatFactRepository)  {
    suspend fun execute(): CatFact {
        return repository.getCatFact()
    }
}