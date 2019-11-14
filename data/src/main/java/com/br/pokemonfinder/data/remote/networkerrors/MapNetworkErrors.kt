package com.br.pokemonfinder.data.remote.networkerrors

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class MapNetworkErrors<T> : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .compose(NetworkExceptionHandler())
            .compose(HttpExceptionHandler())
    }

}