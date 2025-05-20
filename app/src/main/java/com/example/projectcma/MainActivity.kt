package com.example.projectcma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.projectcma.navigation.AppNavigation
import com.example.projectcma.ui.theme.ProjectCMATheme
import com.example.projectcma.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val pokemonViewModel = PokemonViewModel()

        setContent {ProjectCMATheme {
            val navController = rememberNavController()
            AppNavigation(navController, pokemonViewModel)
            }
        }
    }
}
