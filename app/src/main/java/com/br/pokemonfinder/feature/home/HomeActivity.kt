package com.br.pokemonfinder.feature.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.br.pokemonfinder.R
import com.br.pokemonfinder.domain.entity.Pokemon
import com.br.pokemonfinder.feature.common.ActivityBase
import com.br.pokemonfinder.feature.common.ViewState
import com.br.pokemonfinder.util.extensions.toast
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : ActivityBase() {

    private val viewModel: HomeViewModel by viewModel()
    private var sortedCre = false
    private var doubleBackToExitPressedOnce = false
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        progress = progressBar

        viewModel.typeFilter = intent.extras.getString(TYPE_FILTER, "")
        bindListeners()
        setSupportActionBar(toolbarHome)

        sort.setOnClickListener {
            sorted()
            sortedCre = !sortedCre
        }
    }

    private fun bindListeners() {
        viewModel.getState().observe(this, Observer { state ->
            when (state) {
                is ViewState.Loading -> showLoading()
                is ViewState.Success -> prepareAdapter(state.data)
                is ViewState.Failed -> showError(state.throwable)
            }
        })
    }

    private fun prepareAdapter(data: List<Pokemon>) {
        hideLoading()
        viewModel.pokemonGroup = data
        homeAdapter = HomeAdapter(viewModel.filterByType())
        pokemonList.adapter = homeAdapter
        sorted()
    }

    private fun sorted() {
        if (sortedCre) {
            arrow.rotation = 360F
            homeAdapter.filterAdapter(viewModel.bySortDec(homeAdapter.pokemonGroup))
        } else {
            arrow.rotation = 180F
            homeAdapter.filterAdapter(viewModel.bySortCre(homeAdapter.pokemonGroup))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        prepareSearch(menu)
        return true
    }

    private fun prepareSearch(menu: Menu?) {
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                homeAdapter.filterAdapter(viewModel.filterByName(newText))
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }
        })
        searchView.setOnCloseListener {
            homeAdapter.filterAdapter(viewModel.filterByType())
            true
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        this.toast(getString(R.string.exit))

        Handler().postDelayed(
            { doubleBackToExitPressedOnce = false },
            2000
        )
    }


    companion object {
        const val TYPE_FILTER = "type_filter"
        fun launchIntent(context: Context, type: String): Intent {
            val intent = Intent(context, HomeActivity::class.java)
            intent.putExtra(TYPE_FILTER, type)
            return intent
        }
    }
}
