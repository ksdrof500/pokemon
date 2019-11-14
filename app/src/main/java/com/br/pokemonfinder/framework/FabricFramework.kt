package com.br.pokemonfinder.framework

import android.app.Application
import com.br.pokemonfinder.BuildConfig
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric

class FabricFramework: Framework {

    override fun init(application: Application) {
        val core = CrashlyticsCore.Builder()
            .disabled(BuildConfig.DEBUG)
            .build()

        Fabric.with(application, Crashlytics.Builder().core(core).build())
    }

}