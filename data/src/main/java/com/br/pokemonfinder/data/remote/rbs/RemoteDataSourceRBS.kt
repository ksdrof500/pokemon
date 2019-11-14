package com.br.pokemonfinder.data.remote.rbs

import com.br.pokemonfinder.data.remote.api.RbsApi
import com.br.pokemonfinder.data.remote.mapper.ConfigMapper
import com.br.pokemonfinder.domain.entity.Config
import io.reactivex.Observable

class RemoteDataSourceRBS(private val rbsApi: RbsApi): RemoteSourceRBS {

    override fun fetchConfig(): Observable<Config> {
        return rbsApi.fetchConfig()
            .map { ConfigMapper.map(it) }
    }

}