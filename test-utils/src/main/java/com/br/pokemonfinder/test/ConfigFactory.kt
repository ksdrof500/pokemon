package com.br.pokemonfinder.test

import com.br.pokemonfinder.domain.entity.Config

object ConfigFactory {

    fun stub(requiredVersion: String = "1.0.0") = Config(
        coverUrl = "",
        updateText = "Update App",
        requiredVersion = requiredVersion
    )

}