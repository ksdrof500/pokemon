package com.br.pokemonfinder.feature.person.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.br.pokemonfinder.R
import kotlinx.android.synthetic.main.fragment_lets_go.view.*


class LetsGoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root =  inflater.inflate(R.layout.fragment_lets_go, container, false)
        root.next.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.content,
                    TypeFragment.newInstance(),
                    TypeFragment::class.java.name).
                    addToBackStack(LetsGoFragment::class.java.name)
                .commit()
        }

        return root
    }

    companion object {
        fun newInstance() = LetsGoFragment()
    }
}
