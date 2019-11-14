package com.br.pokemonfinder.util.extensions

import android.content.Context

fun Context.dpToPx(dp: Int) = dpToPx(dp.toFloat())
fun Context.dpToPx(dp: Float) = Math.round(dp * resources.displayMetrics.density)
