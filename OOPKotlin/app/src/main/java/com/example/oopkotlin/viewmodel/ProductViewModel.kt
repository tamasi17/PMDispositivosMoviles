package com.example.oopkotlin.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.oopkotlin.data.ProductRepo
import com.example.oopkotlin.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// viewmodel/ProductViewModel.kt
class ProductViewModel : ViewModel() {

    // 1. Estado Mutable (StateFlow)
    // Usamos StateFlow para exponer la lista de productos de manera reactiva.
    // La IU (Compose) se suscribirá a este flujo de datos.
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    // 2. Inicialización
    init {
        // En un caso real, aquí llamaríamos a una API o base de datos.
        // Aquí simulamos la carga de datos del repositorio.
        loadProducts()
    }

    // 3. Lógica para cargar datos
    private fun loadProducts() {
        // Aqui podriamos simular un pequeño retraso si quisiéramos mostrar un ProgressBar
        val loadedProducts = ProductRepo.getAllProducts()

        // 4. Actualizar el estado (hacer que la UI se recomponga automáticamente)
        _products.value = loadedProducts
    }

    // Opcional: Lógica de negocio (ej. simular añadir al carrito)
    fun addToCart(productId: Int) {
        // En una app real, actualizarías el estado del carrito aquí.
        Log.d("ViewModel", "Producto ID $productId gestionado por ViewModel.")
    }
}