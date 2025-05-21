package com.example.projectcma.ui.login

import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectcma.R

@Preview
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .background(Color(0xFFCC0000))
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFCC0000))
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.topbar_pokedex),
                contentDescription = "botones superiores pokédex",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
            ) {
                Text(
                    text = "POKÉDEX OF ARGENTINA",
                    fontSize = 20.sp,
                    color = Color(0xFFFFFFFF),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(200.dp)
                        .align(Alignment.CenterVertically)
                )

                Surface(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp),
                    tonalElevation = 2.dp,
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pokeball_icon),
                        contentDescription = "logo de pokeball",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }

        }





        Surface(
            modifier = Modifier
                .width(350.dp)
                .height(500.dp)
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
                .border(width = 6.dp, Color(0xFFB0B0B0), shape = RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_login),
                contentDescription = "logo de pokeball",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.5f)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .clip( RoundedCornerShape(10.dp))
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .alpha(0.8f)
                        .padding(bottom = 10.dp)
                        .background(color = Color(0xFF1A1A1A), shape = RoundedCornerShape(10.dp)),
                    value = "Ingrese su gmail",
                    onValueChange = {}
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .alpha(0.8f)
                        .padding(top = 10.dp)
                        .background(color = Color(0xFF1A1A1A), shape = RoundedCornerShape(10.dp)),
                    value = "Ingrese contraseña",
                    onValueChange = {}
                )
            }

        }

        Surface(
            modifier = Modifier
                .width(400.dp)
                .height(200.dp)
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(20.dp))
                .border(width = 3.dp, Color(0xFFB0B0B0), shape = RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp),
            tonalElevation = 10.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.keystick_pokedex),
                contentDescription = "imagen joystick pokédex",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .padding(start = 85.dp, end = 145.dp,top = 70.dp, bottom = 20.dp)
                    .border(
                        2.dp,
                        color = Color(0xFF1A1A1A),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp))
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFB0B0B0)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "VALIDARSE",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

            }
        }


    }
}