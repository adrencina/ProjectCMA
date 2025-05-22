package com.example.projectcma.ui.home

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.projectcma.R

@Composable
fun ProductDetailScreen(productId: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5D7F3))
            .padding(start = 8.dp, end = 8.dp, top = 48.dp, bottom = 48.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //TopBar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFFA88CD6))
            ) {

                //Imagen de Pokebola
                Image(
                    painter = painterResource(id = R.drawable.pokeball_icon),
                    contentDescription = "Nombre Pokemon",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                        .size(48.dp)//Tamaño de la imagen
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = "Fuecoco",
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFDFDFD)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            //Recuadro imagen de Pokémon
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(Color(0x40FFFFFF))
            ){
                Image(painter = painterResource(id = R.drawable.fuecoco),
                    contentDescription = "Nombre del Pokemon",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(160.dp) //Tamaño de la imagen
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            //TopDescripción
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFFA88CD6))
            ) {
                Text(
                    text = "Pokémon Fuegodrilo",
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFDFDFD)
                )
            }

            //Recuadro imagen de Pokémon
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(196.dp)
                    .background(Color(0x80FFFFFF))
                    .padding(8.dp)
            ){
                Text(text = "Yace sobre rocas calientes, cuyo calor transforma en energía ígnea tras absorberlo por sus escamas rectangulares.",
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF6E6E6E),
                    fontSize = 24.sp
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE94125)
                )
                ) {
                Text("¡Ver más!")
            }
        }
    }
}
