package com.br.pokemonfinder.data.local

import android.annotation.SuppressLint
import android.content.Context
import com.br.pokemonfinder.domain.entity.Config
import com.google.gson.Gson

@SuppressLint("ApplySharedPref")
class ConfigLocalDataSource(private val context: Context): ConfigLocalSource {

    private val gson by lazy { Gson() }

    companion object {
        private const val CONFIG_KEY = "config"
    }

    private val sharedPref by lazy {
        context.getSharedPreferences("config.cache", Context.MODE_PRIVATE)
    }

    override fun get(): Config? {
        val savedData = sharedPref.getString(CONFIG_KEY, null)
        return gson.fromJson<Config>(savedData, Config::class.java)
    }

    override fun save(config: Config) {
        val saveData = gson.toJson(config)

        sharedPref.edit()
            .putString(CONFIG_KEY, saveData)
            .commit()
    }

}