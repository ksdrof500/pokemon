package com.br.pokemonfinder.domain.interactor

import com.br.pokemonfinder.domain.entity.Config
import com.br.pokemonfinder.domain.repository.ConfigRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

class GetConfigUseCase(
    private val repository: ConfigRepository,
    private val scheduler: Scheduler) {

    fun execute(): Observable<Config> {
        return repository.fetchConfig()
            .subscribeOn(scheduler)
    }

}