package com.br.pokemonfinder.data.remote.api

import com.br.pokemonfinder.data.remote.model.PokemonPayload
import com.br.pokemonfinder.data.remote.model.TypePayload
import io.reactivex.Observable
import retrofit2.http.GET

interface VortigoApi {

    @GET("types.json")
    fun fetchType(): Observable<TypePayload>

    @GET("pokemons.json")
    fun fetchPokemon(): Observable<List<PokemonPayload>>

}