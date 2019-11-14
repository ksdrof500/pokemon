package com.br.pokemonfinder.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "pokemon")
class PokemonModel {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    lateinit var thumbnailImage: String
    lateinit var name: String

    @TypeConverters(Converters::class)
    lateinit var typePokemon: ArrayList<String>

}