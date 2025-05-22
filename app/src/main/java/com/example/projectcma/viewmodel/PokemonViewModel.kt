package com.example.projectcma.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectcma.data.remote.api.ApiClient
import com.example.projectcma.data.remote.model.PokemonItem
import com.example.projectcma.data.repository.PokemonRepository
import com.example.projectcma.ui.home.PokemonDetailUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository(ApiClient.pokemonApiService)

    var pokemonDetail by mutableStateOf<PokemonDetailUi?>(null)
        private set

    var pokemonList by mutableStateOf<List<PokemonItem>>(emptyList())
        private set

    var searchQuery by mutableStateOf("")
        private set

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    init {
        loadPokemon()
    }

    private fun loadPokemon() {
        viewModelScope.launch {
            pokemonList = repository.getPokemonList(1000, 0)
        }
    }

    fun onSearchQueryChange(query: String) {
        searchQuery = query
    }

    fun getFilteredList(): List<PokemonItem> {
        return if (searchQuery.isBlank()) pokemonList
        else pokemonList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    fun getPokemonDetail(name: String) {
        viewModelScope.launch {
            try {
                val detail = repository.getPokemonDetail(name)
                val species = repository.getPokemonSpecies(name)

                val description = species.flavorTextEntries
                    .firstOrNull { it.language.name == "es" }?.flavortext
                    ?.replace("\n", " ")?.replace("\u000c", " ") ?: "Sin descripción"

                pokemonDetail = PokemonDetailUi(
                    id = detail.id,
                    name = detail.name.replaceFirstChar { it.uppercaseChar() },
                    imageUrl = detail.sprites.imageUrl,
                    description = description,
                    types = detail.types.map { it.type.name }
                )
            } catch (e: Exception) {
                println("Error cargando detalle: ${e.message}")
            }
        }
    }

    fun toggleTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
    }
}