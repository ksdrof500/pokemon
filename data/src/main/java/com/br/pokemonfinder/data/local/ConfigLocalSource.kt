package com.br.pokemonfinder.data.local

import com.br.pokemonfinder.domain.entity.Config

interface ConfigLocalSource {

    fun get(): Config?
    fun save(config: Config)

}