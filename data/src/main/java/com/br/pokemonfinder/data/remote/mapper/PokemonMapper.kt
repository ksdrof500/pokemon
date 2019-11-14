package com.br.pokemonfinder.data.remote.mapper

import com.br.pokemonfinder.data.remote.model.PokemonPayload
import com.br.pokemonfinder.domain.entity.Pokemon

object PokemonMapper {

    fun map(payload: List<PokemonPayload>): List<Pokemon> {
        val pokemonGroup = ArrayList<Pokemon>()
        payload.forEach {
            pokemonGroup.add(
                Pokemon(
                    name = it.name,
                    thumbnailImage = it.thumbnailImage,
                    type = it.type
                )
            )
        }
        return pokemonGroup
    }


}