package com.clicrbs.jornais.feature.splash

import com.br.pokemonfinder.feature.splash.toUiModel
import com.br.pokemonfinder.test.ConfigFactory
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ConfigUiModelMapper {

    @Test
    fun `verify mapper need update`() {
        val requiredVersion = "2.5.3"
        val currentVersions = listOf("1.0.0", "2.0.0", "2.5.0", "2.5.2", "2", "2.4")

        currentVersions.forEach { currentVersion ->
            val config = ConfigFactory.stub(
                requiredVersion = requiredVersion
            )

            val uiModel = config.toUiModel(currentVersion = currentVersion)

            assertTrue("should update: required $requiredVersion current $currentVersion") {
                uiModel.needUpdate
            }
        }
    }

    @Test
    fun `verify mapper not need update`() {
        val requiredVersion = "2.5.3"
        val currentVersions = listOf("2.5.3", "2.5.4", "2.6.0", "3.4.0", "4.0.0", "6", "3")

        currentVersions.forEach { currentVersion ->
            val config = ConfigFactory.stub(
                requiredVersion = requiredVersion
            )

            val uiModel = config.toUiModel(currentVersion = currentVersion)

            assertFalse("should not update: required $requiredVersion current $currentVersion") {
                uiModel.needUpdate
            }
        }
    }

}