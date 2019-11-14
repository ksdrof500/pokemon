package com.br.pokemonfinder.data.di


import com.br.pokemonfinder.data.ConfigDataRepository
import com.br.pokemonfinder.data.PokemonDataRepository
import com.br.pokemonfinder.data.TypeDataRepository
import com.br.pokemonfinder.domain.repository.ConfigRepository
import com.br.pokemonfinder.domain.repository.PokemonGroupRepository
import com.br.pokemonfinder.domain.repository.TypeGroupRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<ConfigRepository> {
        ConfigDataRepository(
            remoteSource = get(),
            configLocalSource = get()
        )
    }

    factory<TypeGroupRepository> {
        TypeDataRepository(
            localSource = get(),
            remoteSource = get()
        )
    }

    factory<PokemonGroupRepository> {
        PokemonDataRepository(
            localSource = get(),
            remoteSource = get()
        )
    }

}

val dataModules = listOf(repositoryModule, dataLocalModule, dataRemoteModule)