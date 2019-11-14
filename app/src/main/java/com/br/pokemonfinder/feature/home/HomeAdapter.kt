package com.br.pokemonfinder.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.pokemonfinder.R
import com.br.pokemonfinder.domain.entity.Pokemon
import com.bumptech.glide.Glide


class HomeAdapter(var pokemonGroup: List<Pokemon>) : RecyclerView.Adapter<HomeAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemonGroup[position])
    }

    override fun getItemCount(): Int = pokemonGroup.size

    fun filterAdapter(pokemonFiltered: List<Pokemon>) {
        pokemonGroup = pokemonFiltered
        notifyDataSetChanged()
    }

    inner class PokemonViewHolder(inflater: LayoutInflater, private val parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list, parent, false)) {
        private var icon: ImageView? = null
        private var name: TextView? = null


        init {
            icon = itemView.findViewById(R.id.icon)
            name = itemView.findViewById(R.id.name)
        }

        fun bind(pokemon: Pokemon) {
            icon?.let { Glide.with(parent.context).load(pokemon.thumbnailImage).into(it) }
            name?.text = pokemon.name
        }

    }
}