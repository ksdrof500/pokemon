package com.br.pokemonfinder.feature.person.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.br.pokemonfinder.R
import com.br.pokemonfinder.domain.entity.TypeItem
import com.bumptech.glide.Glide

class TypeAdapter(context: Context, resource: Int, pickerItems: List<TypeItem>) :
    ArrayAdapter<TypeItem>(context, resource, pickerItems) {

    private var typeAdapterItems: List<TypeItem> = pickerItems

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return TypeAdapterView(position, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return TypeAdapterView(position, parent)
    }

    private fun TypeAdapterView(position: Int, parent: ViewGroup): View {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customView = layoutInflater.inflate(R.layout.item_list, parent, false)
        val imageView = customView.findViewById(R.id.icon) as ImageView
        val textView = customView.findViewById(R.id.name) as TextView

        Glide.with(context).load(typeAdapterItems[position].thumbnailImage).into(imageView)
        textView.text = typeAdapterItems[position].name
        return customView
    }

}