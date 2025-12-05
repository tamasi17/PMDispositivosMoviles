package com.example.oopkotlin.models

// Product.kt
data class Product(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val longDescription: String,
    val price: Double,
    val imageUrl: Int // Usaremos un ID de recurso drawable por simplicidad
)