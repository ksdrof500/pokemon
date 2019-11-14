package com.br.pokemonfinder.data

import com.br.pokemonfinder.data.local.PokemonLocalSource
import com.br.pokemonfinder.data.remote.networkerrors.MapNetworkErrors
import com.br.pokemonfinder.data.remote.vortigo.RemotePokemonSourceVortigo
import com.br.pokemonfinder.domain.entity.Pokemon
import com.br.pokemonfinder.domain.repository.PokemonGroupRepository
import io.reactivex.Observable

class PokemonDataRepository(
    private val localSource: PokemonLocalSource,
    private val remoteSource: RemotePokemonSourceVortigo
): PokemonGroupRepository {

    override fun get(): List<Pokemon> {
        return localSource.get()
    }

    override fun fetchPokemonGroup(): Observable<List<Pokemon>> {
        return remoteSource.fetchPokemonGroup()
            .doOnNext { localSource.save(it) }
            .onErrorReturn { get() }
            .compose(MapNetworkErrors())
    }

}