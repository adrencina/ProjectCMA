package com.example.projectcma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.projectcma.navigation.AppNavigation
import com.example.projectcma.ui.theme.ProjectCMATheme
import com.example.projectcma.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {
    private val pokemonViewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val isDarkTheme by pokemonViewModel.isDarkTheme.collectAsState()

            ProjectCMATheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()
                AppNavigation(
                    navController = navController,
                    pokemonViewModel = pokemonViewModel,
                    isDarkTheme = isDarkTheme,
                    onToggleTheme = pokemonViewModel::toggleTheme
                )
            }
        }
    }
}