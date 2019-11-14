package com.br.pokemonfinder.data.remote.vortigo

import com.br.pokemonfinder.data.remote.api.VortigoApi
import com.br.pokemonfinder.data.remote.mapper.PokemonMapper
import com.br.pokemonfinder.domain.entity.Pokemon
import io.reactivex.Observable

class RemotePokemonDataSourceVortigo(private val vortigoApi: VortigoApi) : RemotePokemonSourceVortigo {

    override fun fetchPokemonGroup(): Observable<List<Pokemon>> {
        return vortigoApi.fetchPokemon()
            .map { PokemonMapper.map(it) }
    }

}