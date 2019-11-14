package com.br.pokemonfinder.domain.entity

data class Pokemon(
    val name: String,
    val thumbnailImage: String,
    val type: ArrayList<String>
)