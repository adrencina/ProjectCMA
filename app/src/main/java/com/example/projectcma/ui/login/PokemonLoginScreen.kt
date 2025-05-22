package com.example.projectcma.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectcma.R
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.example.projectcma.ui.theme.RobotoBold

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    val viewModel = remember { PokemonLoginViewModel() }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.loginSuccess) {
        if (uiState.loginSuccess) {
            onLoginSuccess()
            viewModel.resetLoginSuccess()
        }
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFCC0000),
        contentWindowInsets = WindowInsets.systemBars,

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            // HEADER
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Column(
                    modifier = Modifier
                        .padding(top = 24.dp, start = 8.dp)
                ) {
                    Text(
                        text = "POKEDEX",
                        fontSize = 34.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontFamily = RobotoBold
                    )

                    Text(
                        text = "ARGENTINA",
                        fontSize = 34.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontFamily = RobotoBold
                    )

                }

                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(top = 24.dp, start = 12.dp),
                    painter = painterResource(id = R.drawable.pokeballloginicon),
                    contentDescription = "logo de pokeball",
                    contentScale = ContentScale.Fit,
                )
            }

            // LOGIN CARD
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .padding(top = 16.dp)
                    .border(width = 6.dp, Color.White,
                        shape = RoundedCornerShape(20.dp)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.background_login),
                        contentDescription = "fondo login",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.1f)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {

                        Text(
                            text = "¡Bienvenidos!",
                            style = MaterialTheme.typography.titleLarge,
                            fontFamily = RobotoBold,
                            color = Color(0xFFCC0000),
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Ingresá tus datos para comenzar la aventura.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFCC0000),
                            modifier = Modifier
                                .padding(bottom = 14.dp)
                                .align(Alignment.CenterHorizontally)
                                .alpha(0.6f)
                        )

                        OutlinedTextField(
                            value = uiState.email,
                            onValueChange = { viewModel.onEmailChange(it) },
                            label = { Text("Correo electrónico") },
                            isError = uiState.emailError != null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )
                        uiState.emailError?.let { errorMessage ->
                            Text(text = errorMessage, color = Color.Red, fontSize = 12.sp)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = uiState.password,
                            onValueChange = { viewModel.onPasswordChange(it) },
                            label = { Text("Contraseña") },
                            isError = uiState.passwordError != null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp),
                            singleLine = true,
                            visualTransformation = if (uiState.showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                                    Icon(
                                        imageVector = if (uiState.showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                        contentDescription = "Mostrar/ocultar contraseña"
                                    )
                                }
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )
                        uiState.passwordError?.let { errorMessage ->
                            Text(text = errorMessage, color = Color.Red, fontSize = 12.sp)
                        }
                    }
                }
            }

            // BOTÓN DE VALIDARSE

                Box(
                    modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 16.dp)
                        .background(Color(0xFFCC0000))
                        .border(
                            2.dp,
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .background(if (uiState.isFormValid) Color(0xFF13C513) else Color.Gray)
                        .clickable(enabled = uiState.isFormValid) {
                            viewModel.onLogin()
                        }
                        .padding(vertical = 10.dp, horizontal = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "INICIAR SESIÓN",
                        fontSize = 22.sp,
                        fontFamily = RobotoBold,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                    )
                }
            }
        }
    }