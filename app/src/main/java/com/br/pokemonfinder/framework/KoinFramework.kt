package com.br.pokemonfinder.framework

import android.app.Application
import com.br.pokemonfinder.BuildConfig
import com.br.pokemonfinder.data.di.dataModules
import com.br.pokemonfinder.di.viewModelModule
import com.br.pokemonfinder.domain.di.domainModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinFramework: Framework {

    override fun init(application: Application) {
        startKoin {
            if (BuildConfig.DEBUG)
                androidLogger()

            androidContext(application)
            androidFileProperties("data.properties")

            modules(dataModules + domainModules + viewModelModule)
        }
    }

}