package com.br.pokemonfinder.feature.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.br.pokemonfinder.domain.entity.Pokemon
import com.br.pokemonfinder.domain.interactor.GetPokemonGroupUseCase
import com.br.pokemonfinder.feature.common.RxViewModel
import com.br.pokemonfinder.feature.common.StateMachine
import com.br.pokemonfinder.feature.common.ViewState
import com.br.pokemonfinder.util.RxUtils
import com.br.pokemonfinder.util.extensions.toImmutable
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber

class HomeViewModel(
    private val getPokemonGroupUseCase: GetPokemonGroupUseCase,
    private val context: Context,
    private val uiScheduler: Scheduler
) : RxViewModel() {

    lateinit var typeFilter: String
    lateinit var pokemonGroup: List<Pokemon>

    private val state = MutableLiveData<ViewState<List<Pokemon>>>().apply {
        value = ViewState.Loading
    }

    init {
        fetchPokemon()
    }

    fun getState() = state.toImmutable()

    private fun fetchPokemon() {
        disposables += getPokemonGroupUseCase.execute()
            .compose(StateMachine())
            .compose(RxUtils.replayOnError())
            .observeOn(uiScheduler)
            .subscribe(
                { state.value = it },
                { Timber.e(it) }
            )

    }

    fun filterByName(name: String): List<Pokemon> {
       return pokemonGroup.filter {
            it.name.contains(name, true)
        }
    }

    fun filterByType(): List<Pokemon> {
        return pokemonGroup.filter {
            it.type.contains(typeFilter)
        }
    }

    fun bySortCre(pokemonGroup: List<Pokemon>): List<Pokemon> {
        return pokemonGroup.sortedBy {it.name}
    }

    fun bySortDec(pokemonGroup: List<Pokemon>): List<Pokemon> {
        return pokemonGroup.sortedByDescending {it.name}
    }

}