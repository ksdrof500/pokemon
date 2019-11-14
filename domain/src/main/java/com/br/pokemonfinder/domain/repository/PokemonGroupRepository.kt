package com.br.pokemonfinder.domain.repository

import com.br.pokemonfinder.domain.entity.Pokemon
import io.reactivex.Observable

interface PokemonGroupRepository {

    fun get(): List<Pokemon>
    fun fetchPokemonGroup(): Observable<List<Pokemon>>

}