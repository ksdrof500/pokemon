package com.br.pokemonfinder.feature.updateapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.pokemonfinder.R
import kotlinx.android.synthetic.main.activity_update_app.*

class UpdateAppActivity: AppCompatActivity() {

    private val messageUpdate by lazy { intent.getStringExtra(EXTRA_MESSAGE) }

    companion object {
        private const val EXTRA_MESSAGE = "message"

        fun launchIntent(context: Context, message: String): Intent {
            val intent = Intent(context, UpdateAppActivity::class.java)

            intent.putExtra(EXTRA_MESSAGE, message)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_app)

        txtUpdate.text = messageUpdate
    }

}