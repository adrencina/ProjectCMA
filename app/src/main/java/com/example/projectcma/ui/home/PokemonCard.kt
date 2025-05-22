package com.example.projectcma.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.projectcma.R
import com.example.projectcma.data.remote.api.ApiConstants
import com.example.projectcma.data.remote.model.PokemonItem
import java.util.Locale

@Composable
fun PokemonCard(
    pokemon: PokemonItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val id = pokemon.url.trimEnd('/').split("/").last()
    val imageUrl = "${ApiConstants.SPRITE_IMAGE_URL}$id.png"

    Card(
        modifier = modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .border(3.dp, Color.Black)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xB2FF0000))
                    .border(3.dp, Color.Black)
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pokeballicon),
                            contentDescription = "Pokébola",
                            modifier = Modifier.size(24.dp),
                            alignment = Alignment.Center
                        )
                    }

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = pokemon.name.replaceFirstChar { it.uppercase(Locale.ROOT) },
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(110.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    val samplePokemon = PokemonItem(
        name = "pikachu",
        url = "https://pokeapi.co/api/v2/pokemon/25/"
    )
    PokemonCard(pokemon = samplePokemon, onClick = {})
}
