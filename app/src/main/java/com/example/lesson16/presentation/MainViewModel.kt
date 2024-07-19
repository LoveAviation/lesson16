package com.example.lesson16.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson16.domain.CatFactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: CatFactUseCase): ViewModel() {
    private val _textFlow = MutableStateFlow("Initial value")
    val textFlow : StateFlow<String> = _textFlow

    init {
        reloadCatFact()
    }

    fun reloadCatFact(){
        viewModelScope.launch{
            _textFlow.value = useCase.execute().text
        }
    }
}