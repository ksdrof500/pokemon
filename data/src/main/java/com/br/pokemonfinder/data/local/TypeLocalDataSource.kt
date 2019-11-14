package com.br.pokemonfinder.data.local

import com.br.pokemonfinder.data.local.model.TypeModel
import com.br.pokemonfinder.data.remote.mapper.TypeMapper
import com.br.pokemonfinder.domain.entity.TypeItem

class TypeLocalDataSource(private val db: AppDatabase): TypeLocalSource {

    override fun get(): List<TypeItem> {
        return TypeMapper.map(db.typeDao().getAll())
    }

    override fun save(type: List<TypeItem>) {
        type.forEach {
            val item = TypeModel()
            item.name = it.name
            item.thumbnailImage = it.thumbnailImage
            db.typeDao().add(item)
        }

    }


}