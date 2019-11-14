package com.br.pokemonfinder.data.remote.api

import com.br.pokemonfinder.data.remote.model.ConfigPayload
import io.reactivex.Observable
import retrofit2.http.GET

interface RbsApi {

    @GET("android/settings")
    fun fetchConfig(): Observable<ConfigPayload>

}