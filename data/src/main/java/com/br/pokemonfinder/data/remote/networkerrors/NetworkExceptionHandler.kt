package com.br.pokemonfinder.data.remote.networkerrors

import com.br.pokemonfinder.domain.exception.NetworkException
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

internal class NetworkExceptionHandler<T> : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .onErrorResumeNext { throwable: Throwable ->
                Observable.error(mapError(throwable))
            }
    }

    private fun mapError(throwable: Throwable) = when {
        isTimeoutError(throwable) -> NetworkException.TimeoutException
        isConnectionError(throwable) -> NetworkException.ConnectionException
        else -> throwable
    }

    private fun isTimeoutError(throwable: Throwable): Boolean {
        return throwable is SocketTimeoutException || throwable is TimeoutException
    }

    private fun isConnectionError(throwable: Throwable): Boolean {
        return throwable is ConnectException || throwable is UnknownHostException
    }

}
