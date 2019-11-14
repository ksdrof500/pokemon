package com.br.pokemonfinder.domain.repository

import com.br.pokemonfinder.domain.entity.TypeItem
import io.reactivex.Observable

interface TypeGroupRepository {

    fun get(): List<TypeItem>
    fun fetchTypeGroup(): Observable<List<TypeItem>>

}