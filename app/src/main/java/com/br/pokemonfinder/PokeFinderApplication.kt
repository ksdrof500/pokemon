package com.br.pokemonfinder

import android.app.Application
import com.br.pokemonfinder.framework.*

class PokeFinderApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        listOf(
            KoinFramework(),
            RxFramework(),
            TimberFramework(),
            StethoFramework(),
            FabricFramework(),
            StrictModeFramework()
        ).forEach { framework ->
            framework.init(this)
        }
    }

}