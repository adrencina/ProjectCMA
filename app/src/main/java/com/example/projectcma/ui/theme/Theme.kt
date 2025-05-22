package com.example.projectcma.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores base personalizados
val LightGreen = Color(0xFFE8F5E9)         // Fondo principal (claro)
val DarkGreen = Color(0xFF388E3C)          // Cards, botones principales
val White = Color(0xFFFFFFFF)
val DarkText = Color(0xFF212121)
val GrayText = Color(0xFF797777)
val LightGray = Color(0xFFBDBDBD)
val Red = Color(0xFFD32F2F)                // Errores o acciones destructivas

// Paleta clara
private val LightColorScheme = lightColorScheme(
    primary = DarkGreen,
    onPrimary = White,
    secondary = GrayText,
    onSecondary = White,
    background = Color.White,
//    background = LightGreen,
    onBackground = DarkText,
    surface = White,
    onSurface = DarkText,
    error = Red,
    onError = White,
    outline = LightGray
)

// Paleta oscura
private val DarkColorScheme = darkColorScheme(
    primary = LightGreen,
    onPrimary = DarkText,
    secondary = LightGray,
    onSecondary = DarkText,
    background = Color(0xFF121212),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE0E0E0),
    error = Red,
    onError = White,
    outline = LightGray
)

@Composable
fun ProjectCMATheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}