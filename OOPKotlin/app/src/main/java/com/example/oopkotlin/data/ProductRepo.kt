package com.example.oopkotlin.data

import com.example.oopkotlin.R
import com.example.oopkotlin.models.Product

object ProductRepo {
        private val products = listOf(
            Product(
                1, "Focusrite Scarlett Solo gen4",
                "Todo lo que necesitas para triunfar con tu música",
                "Da tus primeros pasos con Pro Tools Intro+ para Focusrite, Ableton Live Lite, una suscripción de seis meses a FL Studio Producer Edition.",
                120.99, R.drawable.scarlett
            ),
            Product(
                2, "Oscar Schmidt OS110 21FNE Autoharp", "Autoarpa de 21 acordes",
                "Autoarpa de tapa de arce flameado, cuerpo de pícea maciza, sistema de afinación precisa FT600 incorporado, sistema de pastilla incorporado y acabado satinado",
                1069.99, R.drawable.autoarpa
            ),
            Product(
                3, "James Neligan Cask-Puncheon", "Guitarra acústica resonadora de 4 cuerdas",
                "Guitarra 'Caja de cigarrillos' con tapa de pícea, aros y fondo de pícea, mástil de caoba, diapasón de ovangkol, 2 agujeros 'F' y acabado: Sunburst (Cask burst) a poro abierto. Incluye funda.",
                243.55, R.drawable.cigarbox
            ),
            Product(
                4, "Electro Harmonix Mod 11 Modulator", "Pedal de efectos: Modulador",
                "Modulador con 11 efectos de modulación diferentes, más funciones avanzadas, todo en un pedal compacto. Cuenta con Tap Tempo. Modo momentáneo para cambiar sin problemas los efectos para un acento rápido. Controles: Profundidad, Velocidad, Modo y Volumen/Color. LED: Efecto encendido. Interruptores footswitch: Bypass de efectos.",
                149.95, R.drawable.harmonix
            ),
            Product(
                5, "Flamma FC05 Multi Modulation", "Pedal de efectos digital",
                "Efectos de multimodulación digital. Con 11 algoritmos diferentes. Fuente de alimentación: 9 V, 130 mA. Acabado metalico verde lima.",
                34.29, R.drawable.flamma
            )

            // añadir más productos aquí si hace falta
        )

        fun getAllProducts(): List<Product> = products
        fun getProductById(id: Int): Product? = products.find { it.id == id }

}