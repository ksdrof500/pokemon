package com.br.pokemonfinder.domain.exception

sealed class NetworkException: Exception() {

    object TimeoutException: NetworkException()
    object ConnectionException: NetworkException()

}