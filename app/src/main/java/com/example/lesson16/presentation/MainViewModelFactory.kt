package com.example.lesson16.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lesson16.domain.CatFactUseCase

class MainViewModelFactory(private val useCase: CatFactUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}