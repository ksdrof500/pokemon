package com.br.pokemonfinder.util

import android.content.Context
import com.br.pokemonfinder.BuildConfig
import com.br.pokemonfinder.util.extensions.get
import com.br.pokemonfinder.util.extensions.put

fun putUserPref(context: Context, name: String) {
    context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
        .put("name", name)
}

fun getUserPref(context: Context) : String {
   return context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
        .get("name", "")
}
