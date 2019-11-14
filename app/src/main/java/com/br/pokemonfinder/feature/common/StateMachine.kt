package com.br.pokemonfinder.feature.common

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

sealed class ViewState<out T> {
    object Default : ViewState<Nothing>()
    object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Failed(val throwable: Throwable) : ViewState<Nothing>()
}

class StateMachine<T> : ObservableTransformer<T, ViewState<T>> {

    override fun apply(upstream: Observable<T>): ObservableSource<ViewState<T>> {
        return upstream
            .map { ViewState.Success(it) as ViewState<T> }
            .onErrorReturn { ViewState.Failed(it) }
            .startWith(ViewState.Loading)
    }

}