package com.br.pokemonfinder.data.remote.vortigo

import com.br.pokemonfinder.domain.entity.Pokemon
import io.reactivex.Observable

interface RemotePokemonSourceVortigo {

    fun fetchPokemonGroup(): Observable<List<Pokemon>>
}