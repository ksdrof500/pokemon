package com.br.pokemonfinder.framework

import android.app.Application
import com.br.pokemonfinder.BuildConfig
import com.br.pokemonfinder.util.CrashlyticsTree
import timber.log.Timber

class TimberFramework: Framework {

    override fun init(application: Application) {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format("[%s] (%s:%s)",
                        super.createStackElementTag(element),
                        element.methodName,
                        element.lineNumber)
                }
            })
        }
        else {
            Timber.plant(CrashlyticsTree())
        }
    }


}