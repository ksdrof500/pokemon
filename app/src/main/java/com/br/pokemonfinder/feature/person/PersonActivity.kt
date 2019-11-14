package com.br.pokemonfinder.feature.person

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.pokemonfinder.R
import com.br.pokemonfinder.feature.common.startSplashRevealAnimation
import com.br.pokemonfinder.feature.person.fragment.LetsGoFragment
import kotlinx.android.synthetic.main.activity_person.*

class PersonActivity : AppCompatActivity() {


    companion object {
        fun launchIntent(context: Context): Intent {
            return Intent(context, PersonActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content,
                LetsGoFragment.newInstance(),
                LetsGoFragment::class.java.name)
            .commit()

        if (savedInstanceState == null) {
            rootLayout.post {
                startSplashRevealAnimation(rootLayout)
            }
        }

    }
}
