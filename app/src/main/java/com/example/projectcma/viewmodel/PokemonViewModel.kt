package com.example.projectcma.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectcma.data.remote.api.ApiClient
import com.example.projectcma.data.remote.model.PokemonItem
import com.example.projectcma.data.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository(ApiClient.pokemonApiService)

    var pokemonList by mutableStateOf<List<PokemonItem>>(emptyList())
        private set

    var searchQuery by mutableStateOf("")
        private set

    init {
        loadPokemon()
    }

    private fun loadPokemon() {
        viewModelScope.launch {
            pokemonList = repository.getPokemonList(50, 0)
        }
    }

    fun onSearchQueryChange(query: String) {
        searchQuery = query
    }

    fun getFilteredList(): List<PokemonItem> {
        return if (searchQuery.isBlank()) pokemonList
        else pokemonList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }
}
