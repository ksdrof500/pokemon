package com.br.pokemonfinder.domain.interactor

import com.br.pokemonfinder.domain.entity.TypeItem
import com.br.pokemonfinder.domain.repository.TypeGroupRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

class GetTypeGroupUseCase(
    private val repository: TypeGroupRepository,
    private val scheduler: Scheduler
) {

    fun execute(): Observable<List<TypeItem>> {
        return repository.fetchTypeGroup()
            .subscribeOn(scheduler)
    }

}