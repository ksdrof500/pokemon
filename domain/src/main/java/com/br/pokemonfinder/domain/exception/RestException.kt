package com.br.pokemonfinder.domain.exception

sealed class RestException(private val code: Int): Exception() {

    class ClientError(code: Int): RestException(code)
    class ServerError(code: Int): RestException(code)

    override fun toString() = "RestException - code: $code"

}