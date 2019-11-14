package com.br.pokemonfinder.framework

import android.app.Application
import com.br.pokemonfinder.BuildConfig
import com.facebook.stetho.Stetho

class StethoFramework: Framework {

    override fun init(application: Application) {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(application)
    }

}