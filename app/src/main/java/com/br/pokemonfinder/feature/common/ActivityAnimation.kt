package com.br.pokemonfinder.feature.common

import android.animation.Animator
import android.animation.ObjectAnimator
import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Build
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.br.pokemonfinder.R
import com.br.pokemonfinder.util.extensions.dpToPx
import com.br.pokemonfinder.util.extensions.inflate
import kotlinx.android.synthetic.main.activity_splash.view.*

const val EXTRA_SPLASH_IMAGE = "splash_image"

fun Activity.startSplashRevealAnimation(rootLayout: View) {
    val viewGroup: ViewGroup = findViewById(android.R.id.content)
    val splashView = viewGroup.inflate(R.layout.activity_splash)

    if (!intent.hasExtra(EXTRA_SPLASH_IMAGE))
        return

    overridePendingTransition(0, 0)

    val byteArray = intent.getByteArrayExtra(EXTRA_SPLASH_IMAGE)
    val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

    splashView.animationView.setImageBitmap(bmp)
    viewGroup.addView(splashView, 0)

    rootLayout.isVisible = true

    val animation: Animator

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val finalRadius = rootLayout.height.toFloat()
        val startX = rootLayout.width/2 + dpToPx(100)
        val startY = rootLayout.height/2 + dpToPx(16)

        animation = ViewAnimationUtils.createCircularReveal(rootLayout, startX, startY, 0f, finalRadius)
    }
    else {
        animation = ObjectAnimator.ofFloat(rootLayout,"alpha", 0f, 1f)
    }

    animation.apply {
        duration = 400
        interpolator = AccelerateInterpolator()
        doOnEnd {
            viewGroup.removeView(splashView)
        }
        start()
    }
}