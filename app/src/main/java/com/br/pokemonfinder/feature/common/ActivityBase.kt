package com.br.pokemonfinder.feature.common

import android.content.Intent
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.br.pokemonfinder.feature.login.LoginActivity
import timber.log.Timber

open class ActivityBase : AppCompatActivity() {

    internal lateinit var progress: ProgressBar

    internal fun showLoading() {
        progress.isVisible = true
    }

    internal fun hideLoading() {
        progress.isVisible = false
    }

    internal fun showError(throwable: Throwable) {
        Timber.e(throwable)
        startNextActivity(LoginActivity.launchIntent(this))
    }

    internal fun startNextActivity(intent: Intent) {
        startActivity(intent)
        finish()
    }

}