package com.br.pokemonfinder.data.remote.model

data class TypePayload(
    val results: List<TypeItemPayload>
)

data class TypeItemPayload(
    val thumbnailImage: String,
    val name: String
)
