package com.br.pokemonfinder.feature.person.fragment

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.br.pokemonfinder.R
import com.br.pokemonfinder.domain.entity.TypeItem
import com.br.pokemonfinder.domain.interactor.GetTypeGroupUseCase
import com.br.pokemonfinder.feature.common.RxViewModel
import com.br.pokemonfinder.feature.common.StateMachine
import com.br.pokemonfinder.feature.common.ViewState
import com.br.pokemonfinder.util.RxUtils
import com.br.pokemonfinder.util.extensions.toImmutable
import com.br.pokemonfinder.util.getUserPref
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber

class TypeViewModel(
    private val getTypeGroupUseCase: GetTypeGroupUseCase,
    private val context: Context,
    private val uiScheduler: Scheduler
) : RxViewModel() {

    private val state = MutableLiveData<ViewState<List<TypeItem>>>().apply {
        value = ViewState.Default
    }

    init {
        fetchType()
    }

    fun getState() = state.toImmutable()

    private fun fetchType() {
        disposables += getTypeGroupUseCase.execute()
            .compose(StateMachine())
            .compose(RxUtils.replayOnError())
            .observeOn(uiScheduler)
            .subscribe(
                { state.value = it },
                { Timber.e(it) }
            )

    }


    fun getUser(): String {
        return context.getString(R.string.name_title, getUserPref(context))
    }


}