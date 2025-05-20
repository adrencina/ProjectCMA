package com.example.projectcma.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.projectcma.data.remote.api.ApiConstants
import com.example.projectcma.data.remote.model.PokemonItem
import java.util.Locale

@Composable
fun PokemonCard(pokemon: PokemonItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(160.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(pokemon.name.replaceFirstChar { it.uppercase(Locale.ROOT) })
            val id = pokemon.url.trimEnd('/').split("/").last()
            val imageUrl = "${ApiConstants.SPRITE_IMAGE_URL}$id.png"
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}
