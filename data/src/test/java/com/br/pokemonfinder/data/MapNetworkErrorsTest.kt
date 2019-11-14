package com.br.pokemonfinder.data

import com.br.pokemonfinder.data.remote.networkerrors.MapNetworkErrors
import com.br.pokemonfinder.domain.exception.NetworkException
import com.br.pokemonfinder.domain.exception.RestException
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class MapNetworkErrorsTest {

    @Test
    fun `should not handle any errors`() {
        Observable.range(1, 10)
            .compose(MapNetworkErrors())
            .test()
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun `should handle timeout errors`() {
        assertMapErrors(listOf(
            SocketTimeoutException(),
            TimeoutException()
        ), NetworkException.TimeoutException::class.java)
    }

    @Test
    fun `should handle connection errors`() {
        assertMapErrors(listOf(
            ConnectException(),
            UnknownHostException()
        ), NetworkException.ConnectionException::class.java)
    }

    @Test
    fun `should handle server errors`() {
        val codes = 500 until 600 step 10
        val httpExceptions = codes.map { code ->
            httpException(code, "server error")
        }

        assertMapErrors(httpExceptions, RestException.ServerError::class.java)
    }

    @Test
    fun `should handle client errors`() {
        val codes = 400 until 500 step 10
        val httpExceptions = codes.map { code ->
            httpException(code, "client error")
        }

        assertMapErrors(httpExceptions, RestException.ClientError::class.java)
    }

    @Test
    fun `should not handle any other errors`() {
        assertMapErrors(listOf(NullPointerException()), NullPointerException::class.java)
        assertMapErrors(listOf(RuntimeException()), RuntimeException::class.java)
    }

    private fun assertMapErrors(inputs: List<Exception>, output: Class<out Throwable>) {
        inputs.forEach { input ->
            Observable.error<Unit>(input)
                .compose(MapNetworkErrors())
                .test()
                .assertError(output)
        }
    }

    private fun httpException(statusCode: Int, errorMessage: String): HttpException {
        val jsonMediaType = MediaType.parse("application/json")
        val body = ResponseBody.create(jsonMediaType, errorMessage)
        return HttpException(Response.error<Unit>(statusCode, body))
    }

}