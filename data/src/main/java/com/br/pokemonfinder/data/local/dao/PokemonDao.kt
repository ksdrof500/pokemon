package com.br.pokemonfinder.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.pokemonfinder.data.local.model.PokemonModel

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    fun getAll(): List<PokemonModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg pokemon : PokemonModel)
}