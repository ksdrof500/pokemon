package com.clicrbs.jornais.feature.common

import com.br.pokemonfinder.feature.common.StateMachine
import com.br.pokemonfinder.feature.common.ViewState
import io.reactivex.Observable
import org.junit.Test

class StateMachineTest {

    @Test
    fun `verify the success states`() {
        val data = "test data"

        Observable.just(data)
            .compose(StateMachine())
            .test()
            .assertResult(ViewState.Loading, ViewState.Success(data))
    }

    @Test
    fun `verify the error states`() {
        val exception = NullPointerException()

        Observable.error<Unit>(exception)
            .compose(StateMachine())
            .test()
            .assertResult(ViewState.Loading, ViewState.Failed(exception))
    }

}