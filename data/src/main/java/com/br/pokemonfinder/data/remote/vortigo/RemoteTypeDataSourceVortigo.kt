package com.br.pokemonfinder.data.remote.vortigo

import com.br.pokemonfinder.data.remote.api.VortigoApi
import com.br.pokemonfinder.data.remote.mapper.TypeMapper
import com.br.pokemonfinder.domain.entity.TypeItem
import io.reactivex.Observable

class RemoteTypeDataSourceVortigo(private val vortigoApi: VortigoApi) : RemoteTypeSourceVortigo {

    override fun fetchTypeGroup(): Observable<List<TypeItem>> {
        return vortigoApi.fetchType()
            .map { TypeMapper.map(it) }
    }
}