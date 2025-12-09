package com.example.oopkotlin.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.oopkotlin.models.Product
import com.example.oopkotlin.navigation.Screen
import com.example.oopkotlin.ui.components.ProductListItem

/**
 * Composable que usa LazyColumn para organizar y mostrar todos los ítems.
 */
// ui/screens/ProductListScreen.kt
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavHostController, products: List<Product>) {
    // Scaffold proporciona la estructura básica de la pantalla (AppBar, content, etc.)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Marketplace 🛒") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }
    ) { padding ->
        // LazyColumn: Es la clave para listas eficientes. Solo renderiza los ítems visibles.
        //
        LazyColumn(
            contentPadding = padding, // Aplica el padding necesario de la TopAppBar
            modifier = Modifier.fillMaxSize()
        ) {
            // items(products): Genera un ítem por cada producto en la lista
            items(products, key = { it.id }) { product ->
                ProductListItem(product = product) { productId ->
                    // Acción de navegación al hacer clic
                    // Usa la función helper creada en Screens.kt para construir la ruta
                    navController.navigate(Screen.ProductDetail.createRoute(productId))
                }
            }
        }
    }
}