package com.br.pokemonfinder.framework

import android.app.Application
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber
import java.io.IOException

class RxFramework: Framework {

    override fun init(application: Application) {
        RxJavaPlugins.setErrorHandler { e ->
            var exception = e
            if (exception is UndeliverableException && exception.cause != null) {
                exception = exception.cause!!
            }
            if (exception is IOException) {
                // fine, irrelevant network problem or API that throws on cancellation
                return@setErrorHandler
            }
            if (exception is InterruptedException) {
                // fine, some blocking code was interrupted by a dispose call
                return@setErrorHandler
            }
            if (exception is NullPointerException || exception is IllegalArgumentException) {
                // that's likely a bug in the application
                Thread.currentThread().uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), exception)
                return@setErrorHandler
            }
            if (e is IllegalStateException) {
                // that's a bug in RxJava or in a custom operator
                Thread.currentThread().uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), exception)
                return@setErrorHandler
            }

            Timber.w(exception)
        }
    }

}