package com.br.pokemonfinder.domain.repository

import com.br.pokemonfinder.domain.entity.Config
import io.reactivex.Observable

interface ConfigRepository {

    fun get(): Config
    fun fetchConfig(): Observable<Config>
}