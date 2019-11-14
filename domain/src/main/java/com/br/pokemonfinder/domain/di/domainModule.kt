package com.br.pokemonfinder.domain.di


import com.br.pokemonfinder.domain.interactor.GetConfigUseCase
import com.br.pokemonfinder.domain.interactor.GetPokemonGroupUseCase
import com.br.pokemonfinder.domain.interactor.GetTypeGroupUseCase
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val useCaseModule = module {

    factory {
        GetConfigUseCase(
            repository = get(),
            scheduler = Schedulers.io()
        )
    }

    factory {
        GetTypeGroupUseCase(
            repository = get(),
            scheduler = Schedulers.io()
        )
    }

    factory {
        GetPokemonGroupUseCase(
            repository = get(),
            scheduler = Schedulers.io()
        )
    }
}

val domainModules = listOf(useCaseModule)