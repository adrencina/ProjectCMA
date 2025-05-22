package com.example.projectcma.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.projectcma.ui.components.PokemonTopBar
import com.example.projectcma.viewmodel.PokemonViewModel

@Composable
fun HomeScreen(
    viewModel: PokemonViewModel,
    onItemClick: (String) -> Unit,
) {
    val pokemonList = viewModel.getFilteredList()
    val searchQuery = viewModel.searchQuery

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFCC0000),
        topBar = {
            PokemonTopBar(
                query = searchQuery,
                onQueryChange = viewModel::onSearchQueryChange,
            )
        },
        contentWindowInsets = WindowInsets.systemBars
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 8.dp)
        ) {
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
                                    .padding(2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
