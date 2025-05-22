package com.example.projectcma.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.projectcma.ui.home.HomeScreen
import com.example.projectcma.ui.detail.ProductDetailScreen
import com.example.projectcma.ui.login.LoginScreen
import com.example.projectcma.viewmodel.PokemonViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    pokemonViewModel: PokemonViewModel,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
)
{
    NavHost(
        navController = navController,
        startDestination = NavScreens.LoginScreen.route
    ) {
        composable(NavScreens.LoginScreen.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(NavScreens.HomeScreen.route) {
                        popUpTo(NavScreens.LoginScreen.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(NavScreens.HomeScreen.route) {
            HomeScreen(
                viewModel = pokemonViewModel,
                onItemClick = { productId ->
                    navController.navigate("productDetail/$productId")
                }
            )
        }

        composable(
            route = NavScreens.ProductDetailScreen.route,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(productId = productId)
        }
    }
}