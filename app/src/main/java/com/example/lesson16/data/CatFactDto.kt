package com.example.lesson16.data

import com.example.lesson16.entity.CatFact
import javax.inject.Inject

class CatFactDto @Inject constructor(
    override val fact: String,
    override val length: Int
) : CatFact