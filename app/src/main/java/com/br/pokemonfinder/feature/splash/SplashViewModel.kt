package com.br.pokemonfinder.feature.splash

import android.content.Context
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.br.pokemonfinder.domain.interactor.GetConfigUseCase
import com.br.pokemonfinder.feature.common.RxViewModel
import com.br.pokemonfinder.feature.common.StateMachine
import com.br.pokemonfinder.feature.common.ViewState
import com.br.pokemonfinder.util.RxUtils
import com.br.pokemonfinder.util.extensions.toImmutable
import com.br.pokemonfinder.util.getUserPref
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber

class SplashViewModel(
    private val getConfigUseCase: GetConfigUseCase,
    private val context: Context,
    private val uiScheduler: Scheduler
): RxViewModel() {

    private val state = MutableLiveData<ViewState<ConfigUiModel>>().apply {
        value = ViewState.Loading
    }

    fun getState() = state.toImmutable()

    fun fetchConfig() {
        disposables += getConfigUseCase.execute()
            .map { it.toUiModel() }
            .compose(StateMachine())
            .compose(RxUtils.replayOnError())
            .observeOn(uiScheduler)
            .subscribe(
                { state.value = it },
                { Timber.e(it) }
            )
    }

    fun goToLogin(): Boolean {
        return TextUtils.isEmpty(getUserPref(context))
    }
}