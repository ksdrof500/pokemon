package com.br.pokemonfinder.data

import com.br.pokemonfinder.data.local.ConfigLocalSource
import com.br.pokemonfinder.data.remote.networkerrors.MapNetworkErrors
import com.br.pokemonfinder.data.remote.rbs.RemoteSourceRBS
import com.br.pokemonfinder.domain.entity.Config
import com.br.pokemonfinder.domain.repository.ConfigRepository
import io.reactivex.Observable

class ConfigDataRepository(
    private val remoteSource: RemoteSourceRBS,
    private val configLocalSource: ConfigLocalSource): ConfigRepository {

    override fun get(): Config {
        return configLocalSource.get() ?: throw NullPointerException("Config is null")
    }

    override fun fetchConfig(): Observable<Config> {
        return remoteSource.fetchConfig()
            .doOnNext { configLocalSource.save(it) }
            .onErrorReturn { get() }
            .compose(MapNetworkErrors())
    }

}