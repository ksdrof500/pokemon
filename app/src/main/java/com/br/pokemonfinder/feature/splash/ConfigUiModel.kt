package com.br.pokemonfinder.feature.splash

import com.br.pokemonfinder.BuildConfig
import com.br.pokemonfinder.domain.entity.Config
import kotlin.math.max
import kotlin.math.sign

class ConfigUiModel(
    val needUpdate: Boolean,
    val textUpdate: String
)

private fun compareVersion(currentVersion: String, requiredVersion: String): Int {
    val currentVersionSplit = currentVersion.split(".")
    val requiredVersionSplit = requiredVersion.split(".")

    val length = max(requiredVersionSplit.size, currentVersionSplit.size)

    for (i in 0 until length) {
        val num1 = currentVersionSplit.getOrNull(i)?.toInt() ?: 0
        val num2 = requiredVersionSplit.getOrNull(i)?.toInt() ?: 0

        if (num1 != num2)
            return (num1 - num2).sign
    }

    return 0
}

fun Config.toUiModel(currentVersion: String = BuildConfig.VERSION_NAME) = ConfigUiModel(
    needUpdate = compareVersion(currentVersion, requiredVersion) < 0,
    textUpdate = updateText
)