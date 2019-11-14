package com.br.pokemonfinder.data.remote.mapper

import com.br.pokemonfinder.data.local.model.TypeModel
import com.br.pokemonfinder.data.remote.model.TypePayload
import com.br.pokemonfinder.domain.entity.TypeItem

object TypeMapper {

    fun map(payload: TypePayload): List<TypeItem> {
        val typeGroup = ArrayList<TypeItem>()
        payload.results.forEach {
            typeGroup.add(TypeItem(
                thumbnailImage = it.thumbnailImage,
                name = it.name
            ))
        }
        return typeGroup
    }

    fun map(typeRoom: List<TypeModel>): List<TypeItem> {
        val typeGroup = ArrayList<TypeItem>()
        typeRoom.forEach {
            typeGroup.add(TypeItem(
                thumbnailImage = it.thumbnailImage,
                name = it.name
            ))
        }
        return typeGroup
    }
}