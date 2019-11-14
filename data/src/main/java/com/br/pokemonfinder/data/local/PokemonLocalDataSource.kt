package com.br.pokemonfinder.data.local

import com.br.pokemonfinder.data.local.model.PokemonModel
import com.br.pokemonfinder.domain.entity.Pokemon

class PokemonLocalDataSource(private val db: AppDatabase) : PokemonLocalSource {

    override fun get(): List<Pokemon> {
        db.pokemonDao().getAll().forEach {
            ArrayList<Pokemon>().add(
                Pokemon(
                    name = it.name,
                    thumbnailImage = it.thumbnailImage,
                    type = it.typePokemon
                )
            )
        }
        return ArrayList()
    }

    override fun save(pokemon: List<Pokemon>) {
        pokemon.forEach {
            val item = PokemonModel()
            item.name = it.name
            item.thumbnailImage = it.thumbnailImage
            item.typePokemon = it.type
            db.pokemonDao().add(item)
        }

    }


}