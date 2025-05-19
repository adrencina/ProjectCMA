package com.example.projectcma.navigation

sealed class NavScreens(val route: String) {
    object LoginScreen : NavScreens("login")
    object HomeScreen : NavScreens("home")
    object ProductDetailScreen : NavScreens("productDetail/{productId}") {
        fun createRoute(productId: String) = "productDetail/$productId"
    }
}