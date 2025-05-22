package com.example.projectcma.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
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
import com.example.projectcma.ui.theme.RobotoBold
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
            .background(Color(0xFFCC0000))
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        if (detail != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // HEADER CON ID + NOMBRE + LOGO
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(top = 26.dp)
                        .border(width = 4.dp, Color.Black,
                            shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(8.dp)
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xB2FF0000))
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.pokeballloginicon),
                            contentDescription = "Pokebola",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )

                        Spacer(modifier = Modifier.width(30.dp))

                        Text(
                            text = "${detail.name.replaceFirstChar { it.uppercase() }} (ID: ${detail.id})",
                            fontSize = 22.sp,
                            fontFamily = RobotoBold,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                }


                // CARD PRINCIPAL - IMAGEN
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .padding(top = 16.dp)
                        .border(width = 4.dp, Color.Black,
                            shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    AsyncImage(
                        model = detail.imageUrl,
                        contentDescription = "Imagen de ${detail.name}",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Fit
                    )
                }

                // CARD SECUNDARIA - DATOS
                Surface(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(top = 16.dp)
                        .border(width = 4.dp, Color.Black,
                            shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xB2FF0000)
                )  {
                    // Tipo del Pokémon
                    Text(
                        text = detail.types.joinToString(" / ") { it.uppercase() },
                        fontSize = 20.sp,
                        fontFamily = RobotoBold,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                    )

                    // Descripción
                    Text(
                        text = detail.description,
                        fontSize = 12.sp,
                        fontFamily = RobotoBold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 50.dp)
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.White)
            }
        }
    }
}