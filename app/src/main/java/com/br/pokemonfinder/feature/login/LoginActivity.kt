package com.br.pokemonfinder.feature.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.pokemonfinder.R
import com.br.pokemonfinder.feature.person.PersonActivity
import com.br.pokemonfinder.util.extensions.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        startActivityForResult(viewModel.createSignInIntent(), RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == Activity.RESULT_OK) {
                viewModel.putUser()
                startActivity(PersonActivity.launchIntent(this))
            } else {
                this.toast(getString(R.string.error_login))
            }
        }
    }

    companion object {
        private const val RC_SIGN_IN = 123
        fun launchIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}