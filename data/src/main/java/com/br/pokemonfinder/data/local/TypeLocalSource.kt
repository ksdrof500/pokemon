package com.br.pokemonfinder.data.local

import com.br.pokemonfinder.domain.entity.TypeItem

interface TypeLocalSource {

    fun get(): List<TypeItem>
    fun save(type: List<TypeItem>)

}