package com.example.lesson16.data

import com.example.lesson16.entity.CatFact

class CatFactDto(
    override val text: String,
    override val length: Int
) : CatFact