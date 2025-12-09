package com.example.oopkotlin.navigation

sealed class Screen(val route: String) {
    // 1. Ruta de la lista de productos (destino inicial)
    object ProductList : Screen("productList")

    // 2. Ruta del detalle del producto, necesita un argumento (el ID)
    // Las llaves {productId} indican a Navigation Compose que esta ruta espera un argumento llamado productId.

    object ProductDetail : Screen("productDetail/{productId}") {
        // Función helper para construir la ruta con el ID real
        fun createRoute(productId: Int) = "productDetail/$productId"
    }
}