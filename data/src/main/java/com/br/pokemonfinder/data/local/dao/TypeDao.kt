package com.br.pokemonfinder.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.br.pokemonfinder.data.local.model.TypeModel

@Dao
interface TypeDao {

    @Query("SELECT * FROM typePokemon")
    fun getAll(): List<TypeModel>

    @Insert(onConflict = REPLACE)
    fun add(vararg typeModel : TypeModel)
}