package com.br.pokemonfinder.util

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.rxkotlin.zipWith
import java.util.concurrent.TimeUnit

object RxUtils {

    fun <T> replayOnError(attempts: Int = 3): ObservableTransformer<T, T> {
        return ObservableTransformer { it ->
            it.retryWhen {
                it.zipWith(Observable.range(1, attempts+1))
                    .flatMap { (throwable, attempt) ->
                        if (attempt >= attempts)
                            return@flatMap Observable.error<Long>(throwable)

                        Observable.timer(attempt * 200L, TimeUnit.MILLISECONDS)
                    }
            }
        }
    }

}