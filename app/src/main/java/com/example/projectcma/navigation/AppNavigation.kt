package com.example.projectcma.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.projectcma.ui.home.HomeScreen
import com.example.projectcma.ui.home.ProductDetailScreen
import com.example.projectcma.ui.login.LoginScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavScreens.LoginScreen.route
    ) {
        composable(NavScreens.LoginScreen.route) {
            LoginScreen()
        }
        composable(NavScreens.HomeScreen.route) {
            HomeScreen()
        }
        composable(
            route = NavScreens.ProductDetailScreen.route,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(productId)
        }
    }
}