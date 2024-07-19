package com.example.lesson16.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lesson16.data.CatFactRepository
import com.example.lesson16.databinding.ActivityMainBinding
import com.example.lesson16.domain.CatFactUseCase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels {
        val rep = CatFactRepository()
        val useCase = CatFactUseCase(rep)
        MainViewModelFactory(useCase)
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            mainViewModel.textFlow.collect{ fact ->
                binding.textView.text = fact
            }
        }

        binding.button.setOnClickListener {
            mainViewModel.reloadCatFact()
        }
    }
}