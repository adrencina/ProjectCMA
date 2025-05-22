package com.example.projectcma.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projectcma.ui.components.PokemonTopBar
import com.example.projectcma.viewmodel.PokemonViewModel

@Composable
fun HomeScreen(
    viewModel: PokemonViewModel,
    onItemClick: (String) -> Unit,
    isDarkTheme: Boolean = false,
    onToggleTheme: () -> Unit = {}
) {
    val pokemonList = viewModel.getFilteredList()
    val searchQuery = viewModel.searchQuery

    Scaffold(
        topBar = {
            PokemonTopBar(
                query = searchQuery,
                onQueryChange = viewModel::onSearchQueryChange,
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(pokemonList.chunked(2)) { rowItems ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        rowItems.forEach { pokemon ->
                            PokemonCard(
                                pokemon = pokemon,
                                onClick = { onItemClick(pokemon.name) },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}