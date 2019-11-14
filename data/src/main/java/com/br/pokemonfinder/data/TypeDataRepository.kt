package com.br.pokemonfinder.data

import com.br.pokemonfinder.data.local.TypeLocalSource
import com.br.pokemonfinder.data.remote.networkerrors.MapNetworkErrors
import com.br.pokemonfinder.data.remote.vortigo.RemoteTypeSourceVortigo
import com.br.pokemonfinder.domain.entity.TypeItem
import com.br.pokemonfinder.domain.repository.TypeGroupRepository
import io.reactivex.Observable

class TypeDataRepository(
    private val localSource: TypeLocalSource,
    private val remoteSource: RemoteTypeSourceVortigo
): TypeGroupRepository {

    override fun get(): List<TypeItem> {
        return localSource.get()
    }

    override fun fetchTypeGroup(): Observable<List<TypeItem>> {
        return remoteSource.fetchTypeGroup()
            .doOnNext { localSource.save(it) }
            .onErrorReturn { get() }
            .compose(MapNetworkErrors())
    }

}