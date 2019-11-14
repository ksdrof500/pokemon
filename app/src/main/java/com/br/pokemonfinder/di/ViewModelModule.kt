package com.br.pokemonfinder.di

import com.br.pokemonfinder.feature.home.HomeViewModel
import com.br.pokemonfinder.feature.login.LoginViewModel
import com.br.pokemonfinder.feature.person.fragment.TypeViewModel
import com.br.pokemonfinder.feature.splash.SplashViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        SplashViewModel(
            getConfigUseCase = get(),
            context = get(),
            uiScheduler = AndroidSchedulers.mainThread()
        )
    }
    viewModel {
        LoginViewModel(
           context = get()
        )
    }

    viewModel {
        TypeViewModel(
            getTypeGroupUseCase = get(),
            context = get(),
            uiScheduler = AndroidSchedulers.mainThread()
        )
    }
    viewModel {
        HomeViewModel(
            getPokemonGroupUseCase = get(),
            context = get(),
            uiScheduler = AndroidSchedulers.mainThread()
        )
    }

}