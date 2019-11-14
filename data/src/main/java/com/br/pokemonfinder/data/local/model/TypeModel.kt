package com.br.pokemonfinder.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "typePokemon")
class TypeModel {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    lateinit var thumbnailImage: String
    lateinit var name: String

}