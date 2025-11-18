// Archivo: NameActivity.kt
// ¡El paquete DEBE coincidir con el de MainActivity!
package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.firstapp.ui.theme.FirstAppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
// Asegúrate de importar el R correcto para los strings:
import com.example.firstapp.R

// Clave del Intent (para mantener el dato del nombre consistente)
const val NAME_KEY = "name"

class NameActivity : ComponentActivity() { //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Recuperamos el nombre que viene del Intent
        val name = intent.getStringExtra(NAME_KEY) ?: "Invitado"

        // 2. Usamos setContent para definir la interfaz Compose
        setContent {
            FirstAppTheme {
                ShowNameScreen(
                    name = name,
                    onBackClick = { finish() }
                )
            }
        }
    }
}

@Composable
fun ShowNameScreen(name: String, onBackClick: () -> Unit) {
    // ... (El código de la interfaz Composable que ya tienes va aquí) ...
    val darkBlue = Color(0xFF000060)
    // 1. Define los colores para el gradiente
    val colorStart = darkBlue // Azul muy oscuro (casi negro)
    val colorEnd = Color(0xFF4169E8)   // Azul medio (Royal Blue)

    // 2. Crea el pincel de gradiente lineal
    val gradientBrush = Brush.linearGradient(
        colors = listOf(colorStart, colorEnd), // Colores que usarás
        start = Offset.Zero,                   // Posición inicial (esquina superior izquierda)
        end = Offset(0f, Float.POSITIVE_INFINITY) // Posición final (abajo)
        // Esto crea un gradiente vertical de arriba a abajo.
    )

    val welcomeMessage = stringResource(R.string.welcome_message, name)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush) // originalmente solo darkBlue pero quiero gradientes
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = welcomeMessage,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(32.dp)
            )
        }
        Button(
            onClick = onBackClick,
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            Text(stringResource(R.string.button_back))
        }
    }
}