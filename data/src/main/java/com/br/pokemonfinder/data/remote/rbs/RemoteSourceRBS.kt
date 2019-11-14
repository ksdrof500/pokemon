package com.br.pokemonfinder.data.remote.rbs

import com.br.pokemonfinder.domain.entity.Config
import io.reactivex.Observable

interface RemoteSourceRBS {

    fun fetchConfig(): Observable<Config>

}