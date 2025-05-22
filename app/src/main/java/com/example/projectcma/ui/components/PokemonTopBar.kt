package com.example.projectcma.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTopBar(
    query: String,
    onQueryChange: (String) -> Unit,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.statusBarsPadding()
            .height(80.dp)
            .padding(top = 12.dp),
        title = {
            SearchBar(
                query = query,
                onQueryChange = onQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
            )
        },
        actions = {
            IconButton(onClick = onToggleTheme, modifier = Modifier.padding(top = 6.dp)) {
                Icon(
                    imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = "Cambiar tema"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.05f)
        )
    )
}