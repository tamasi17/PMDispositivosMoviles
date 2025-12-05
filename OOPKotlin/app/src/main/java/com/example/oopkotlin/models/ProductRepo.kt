package com.example.oopkotlin.models

import com.example.oopkotlin.R

object ProductRepo {
        private val products = listOf(
            Product(1, "Focusrite Scarlett Solo gen4", "Todo lo que necesitas para triunfar con tu música", "Da tus primeros pasos con Pro Tools Intro+ para Focusrite, Ableton Live Lite, una suscripción de seis meses a FL Studio Producer Edition.", 120.99, R.drawable.scarlett),
        //Product(2, "Portátil Ultra", "Potente y ligero.", "El portátil más rápido del mercado, ideal para gaming y desarrollo profesional.", 1299.99, R.drawable.product_image_1),
            //Product(3, "Smartphone X", "Cámara de 108MP.", "Un teléfono con una cámara increíble y una batería que dura todo el día.", 699.50, R.drawable.product_image_2),
            // ... al menos dos productos más
        )

        fun getAllProducts(): List<Product> = products
        fun getProductById(id: Int): Product? = products.find { it.id == id }

}