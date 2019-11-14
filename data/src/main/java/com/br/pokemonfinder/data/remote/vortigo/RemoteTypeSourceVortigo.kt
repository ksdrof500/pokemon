package com.br.pokemonfinder.data.remote.vortigo

import com.br.pokemonfinder.domain.entity.TypeItem
import io.reactivex.Observable

interface RemoteTypeSourceVortigo {

    fun fetchTypeGroup(): Observable<List<TypeItem>>
}