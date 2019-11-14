package com.br.pokemonfinder.feature.person.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.br.pokemonfinder.R
import com.br.pokemonfinder.domain.entity.TypeItem
import com.br.pokemonfinder.feature.common.ViewState
import com.br.pokemonfinder.feature.home.HomeActivity
import com.br.pokemonfinder.util.extensions.toast
import kotlinx.android.synthetic.main.fragment_type.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class TypeFragment : Fragment() {

    private val viewModel: TypeViewModel by viewModel()
    private lateinit var typeName: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_type, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindListeners()
        selectType()

        title.text = viewModel.getUser()
        back.setOnClickListener { activity?.onBackPressed() }
        next.setOnClickListener { next() }
    }

    private fun bindListeners() {
        viewModel.getState().observe(this, Observer { state ->
            when (state) {
                is ViewState.Success -> {
                    val typeAdapter = context?.let {
                        TypeAdapter(
                            it,
                            R.layout.item_spinner,
                            state.data
                        )
                    }
                    spinner.adapter = typeAdapter
                }
            }
        })
    }

    private fun selectType() {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                typeName = (spinner.adapter.getItem(i) as TypeItem).name
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {
            }
        }
    }

    private fun next() {
        if (TextUtils.isEmpty(typeName)) {
            context?.toast(getString(R.string.error_select_type))
            return
        }
        startActivity(context?.let {
            HomeActivity.launchIntent(it, typeName)
        })
        activity?.finish()

    }


    companion object {
        fun newInstance() = TypeFragment()
    }
}
