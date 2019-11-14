package com.br.pokemonfinder.data.local

import com.br.pokemonfinder.domain.entity.Pokemon

interface PokemonLocalSource {

    fun get(): List<Pokemon>
    fun save(type: List<Pokemon>)

}