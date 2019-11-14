package com.br.pokemonfinder.feature.splash

import android.animation.Animator
import android.os.Bundle
import androidx.lifecycle.Observer
import com.br.pokemonfinder.R
import com.br.pokemonfinder.feature.common.ActivityBase
import com.br.pokemonfinder.feature.common.EXTRA_SPLASH_IMAGE
import com.br.pokemonfinder.feature.common.ViewState
import com.br.pokemonfinder.feature.login.LoginActivity
import com.br.pokemonfinder.feature.person.PersonActivity
import com.br.pokemonfinder.feature.updateapp.UpdateAppActivity
import com.br.pokemonfinder.util.extensions.toByteArray
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity : ActivityBase() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        progress = progressBar
        viewModel.fetchConfig()

        bindObserver()
    }

    private fun bindObserver() {
        viewModel.getState().observe(this, Observer { state ->
            when (state) {
                is ViewState.Loading -> showLoading()
                is ViewState.Success -> onConfigLoaded(state.data)
                is ViewState.Failed -> showError(state.throwable)
            }
        })
    }

    private fun onConfigLoaded(config: ConfigUiModel) {
        hideLoading()
        animationView.playAnimation()
        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                openNextScreen(config)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
    }

    private fun openNextScreen(config: ConfigUiModel) {
        val intent = when {
            config.needUpdate -> UpdateAppActivity.launchIntent(this, config.textUpdate)
            viewModel.goToLogin() -> LoginActivity.launchIntent(this)
            else -> PersonActivity.launchIntent(this)
        }
        intent.putExtra(EXTRA_SPLASH_IMAGE, animationView.toByteArray())
        startNextActivity(intent)
    }

}
