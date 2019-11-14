package com.br.pokemonfinder.data.di

import com.br.pokemonfinder.data.local.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {

    single { AppDatabase.make(androidContext()) }

    single { get<AppDatabase>().typeDao() }

    single<ConfigLocalSource> { ConfigLocalDataSource(androidContext()) }
    single<TypeLocalSource> { TypeLocalDataSource(get()) }
    single<PokemonLocalSource> { PokemonLocalDataSource(get()) }

}