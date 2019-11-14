package com.br.pokemonfinder.data.remote.model

data class PokemonPayload(
    val name: String,
    val thumbnailImage: String,
    val type: ArrayList<String>
)
