package com.example.projectcma.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PokemonTopBar(
    query: String,
    onQueryChange: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp, bottom = 8.dp)
    ) {
        SearchBar(
            query = query,
            onQueryChange = onQueryChange,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(horizontal = 8.dp)
        )

        HorizontalDivider(
            thickness = 3.dp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
