package com.example.projectcma.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projectcma.viewmodel.PokemonViewModel

@Composable
fun HomeScreen(viewModel: PokemonViewModel, onItemClick: (String) -> Unit) {
    val pokemonList = viewModel.getFilteredList()
    val searchQuery = viewModel.searchQuery

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = viewModel::onSearchQueryChange,
            label = { Text("Buscar Pokémon") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(pokemonList.chunked(2)) { rowItems ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    rowItems.forEach { pokemon ->
                        PokemonCard(pokemon = pokemon, onClick = { onItemClick(pokemon.name) })
                    }
                }
            }
        }
    }
}