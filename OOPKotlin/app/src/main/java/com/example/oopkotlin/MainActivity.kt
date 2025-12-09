package com.example.oopkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.oopkotlin.data.ProductRepo
import com.example.oopkotlin.navigation.Screen
import com.example.oopkotlin.ui.screens.ProductDetailScreen
import com.example.oopkotlin.ui.screens.ProductListScreen
import com.example.oopkotlin.ui.theme.OOPKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OOPKotlinTheme { // Tema de la app
                // 1. Crea el controlador de navegación
                val navController = rememberNavController()

                // 2. Define el NavHost: el contenedor de todas tus pantallas
                NavHost(
                    navController = navController,
                    startDestination = Screen.ProductList.route // Establece la primera pantalla
                ) {
                    // --- DESTINO 1: LISTA DE PRODUCTOS ---
                    composable(Screen.ProductList.route) {
                        // Aquí llamaremos a la función composable que crearemos en el paso 3
                        ProductListScreen(
                            navController = navController, // Se pasa el controlador para que la pantalla pueda navegar
                            products = ProductRepo.getAllProducts()
                        )
                    }

                    // --- DESTINO 2: DETALLE DEL PRODUCTO ---
                    composable(
                        route = Screen.ProductDetail.route,
                        // 3. Define los argumentos que espera la ruta
                        arguments = listOf(
                            navArgument("productId") {
                                type =
                                    NavType.IntType // Especificamos que el argumento es de tipo entero
                            }
                        )
                    ) { backStackEntry ->
                        // 4. Extrae el argumento de la pila de navegación
                        val productId = backStackEntry.arguments?.getInt("productId")

                        // Manejo de errores simple (nunca debería ser null si se usa createRoute)
                        if (productId != null) {
                            // Aquí llamaremos a la función composable que crearemos en el paso 4
                            ProductDetailScreen(
                                navController = navController,
                                productId = productId
                            )
                        } else {
                            // Opcional: Volver atrás si el ID es nulo o inválido
                            navController.popBackStack()


                        }
                    }
                }

            }
        }
    }
}
