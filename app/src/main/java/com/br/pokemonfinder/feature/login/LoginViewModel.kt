package com.br.pokemonfinder.feature.login

import android.content.Context
import android.content.Intent
import com.br.pokemonfinder.R
import com.br.pokemonfinder.feature.common.RxViewModel
import com.br.pokemonfinder.util.putUserPref
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(
    private val context: Context
) : RxViewModel() {

    fun createSignInIntent(): Intent {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        return AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setLogo(R.drawable.pokemon_logo)
            .setTosAndPrivacyPolicyUrls(
                context.getString(R.string.url_terms),
                context.getString(R.string.url_privacy)
            )
            .build()
    }

    fun putUser() {
        FirebaseAuth.getInstance().currentUser?.displayName?.let {
            putUserPref(context,
                it
            )
        }
    }

}