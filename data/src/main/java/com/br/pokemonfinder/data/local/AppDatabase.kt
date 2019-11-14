package com.br.pokemonfinder.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.br.pokemonfinder.data.local.dao.PokemonDao
import com.br.pokemonfinder.data.local.dao.TypeDao
import com.br.pokemonfinder.data.local.model.Converters
import com.br.pokemonfinder.data.local.model.PokemonModel
import com.br.pokemonfinder.data.local.model.TypeModel

@Database(
    entities = [
        TypeModel::class,
        PokemonModel::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        fun make(context: Context) = Room
            .databaseBuilder(context, AppDatabase::class.java, "database")
            .build()
    }

    abstract fun typeDao(): TypeDao
    abstract fun pokemonDao(): PokemonDao

}