package com.br.pokemonfinder.data.di

import com.br.pokemonfinder.data.BuildConfig
import com.br.pokemonfinder.data.remote.api.RbsApi
import com.br.pokemonfinder.data.remote.api.VortigoApi
import com.br.pokemonfinder.data.remote.rbs.RemoteDataSourceRBS
import com.br.pokemonfinder.data.remote.rbs.RemoteSourceRBS
import com.br.pokemonfinder.data.remote.vortigo.RemotePokemonDataSourceVortigo
import com.br.pokemonfinder.data.remote.vortigo.RemotePokemonSourceVortigo
import com.br.pokemonfinder.data.remote.vortigo.RemoteTypeDataSourceVortigo
import com.br.pokemonfinder.data.remote.vortigo.RemoteTypeSourceVortigo
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataRemoteModule = module {

    factory { createOkHttpClient() }

    factory<RemoteSourceRBS> {
        RemoteDataSourceRBS(
            rbsApi = get()
        )
    }

    factory<RemoteTypeSourceVortigo> {
        RemoteTypeDataSourceVortigo(
            vortigoApi = get()
        )
    }

    factory<RemotePokemonSourceVortigo> {
        RemotePokemonDataSourceVortigo(
            vortigoApi = get()
        )
    }

    single {
        createWebService<RbsApi>(
            okHttpClient = get(),
            url = getProperty(DataProperty.RBS_API)
        )
    }

    single {
        createWebService<VortigoApi>(
            okHttpClient = get(),
            url = getProperty(DataProperty.VORTIGO_API)
        )
    }
}

fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .apply {
            if (BuildConfig.DEBUG)
                addNetworkInterceptor(StethoInterceptor())
        }
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

    return retrofit.create(T::class.java)
}
