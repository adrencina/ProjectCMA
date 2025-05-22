package com.example.projectcma.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.projectcma.R
import com.example.projectcma.viewmodel.PokemonViewModel

@Composable
fun ProductDetailScreen(
    productId: String,
    viewModel: PokemonViewModel = remember { PokemonViewModel() }
) {
    LaunchedEffect(productId) {
        viewModel.getPokemonDetail(productId)
    }

    val detail = viewModel.pokemonDetail

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5D7F3))
            .padding(start = 8.dp, end = 8.dp, top = 48.dp, bottom = 48.dp)
    ) {
        if (detail != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // TopBar con ID y nombre
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(Color(0xFFA88CD6))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pokeball_icon),
                        contentDescription = "Pokeball",
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                            .size(48.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Fit
                    )

                    Text(
                        text = "${detail.name} (ID: ${detail.id})",
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFDFDFD)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Imagen del Pokémon
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .background(Color(0x40FFFFFF))
                ) {
                    AsyncImage(
                        model = detail.imageUrl,
                        contentDescription = "Imagen de ${detail.name}",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(160.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Tipo o categoría
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(Color(0xFFA88CD6))
                ) {
                    Text(
                        text = detail.types.joinToString(" / ") { it.uppercase() },
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFFDFDFD)
                    )
                }

                // Descripción
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(196.dp)
                        .background(Color(0x80FFFFFF))
                        .padding(8.dp)
                ) {
                    Text(
                        text = detail.description,
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        color = Color(0xFF6E6E6E),
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* Acción futura */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE94125)
                    )
                ) {
                    Text("¡Ver más!")
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}