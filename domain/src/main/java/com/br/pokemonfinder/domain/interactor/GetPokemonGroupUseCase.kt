package com.br.pokemonfinder.domain.interactor

import com.br.pokemonfinder.domain.entity.Pokemon
import com.br.pokemonfinder.domain.repository.PokemonGroupRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

class GetPokemonGroupUseCase(
    private val repository: PokemonGroupRepository,
    private val scheduler: Scheduler) {

    fun execute(): Observable<List<Pokemon>> {
        return repository.fetchPokemonGroup()
            .subscribeOn(scheduler)
    }

}