package com.br.pokemonfinder.data.remote.mapper

import com.br.pokemonfinder.data.remote.model.ConfigPayload
import com.br.pokemonfinder.domain.entity.Config

object ConfigMapper {

    fun map(payload: ConfigPayload): Config {
        return Config(
            coverUrl = payload.content.coverUrl,
            requiredVersion = payload.version.required,
            updateText = payload.version.updateText
        )
    }

}