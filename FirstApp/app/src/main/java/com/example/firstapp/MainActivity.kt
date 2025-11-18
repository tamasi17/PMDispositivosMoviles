package com.example.firstapp

import androidx.compose.ui.tooling.preview.Preview
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firstapp.ui.theme.FirstAppTheme
import com.example.firstapp.NameActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay // Necesario para simular el Toast

// --- AQUI EMPIEZA EL CODIGO DE LA PANTALLA ---

@Composable
fun MainScreen(onNavigate: (String) -> Unit) {
    // 1. Estados: nameInput guarda el texto, showToast controla el mensaje de error.
    var nameInput by remember { mutableStateOf("") }
    var showToast by remember { mutableStateOf(false) }

    // Usamos Column para apilar los elementos verticalmente y centrarlos
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 2. TextView (Pregunta)
        Text(
            text = "¿Cómo te llamas?",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 3. EditText (Campo de texto/TextField)
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it }, // Actualiza la variable 'nameInput' al escribir
            label = { Text("Name") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 4. Button (Botón de acción)
        Button(onClick = {
            if (nameInput.isBlank()) {
                // Si está vacío, activamos el estado de error
                showToast = true
            } else {
                // Si no está vacío, llamamos a la función de navegación (que usará el Intent)
                onNavigate(nameInput)
            }
        }) {
            Text("IR A SEGUNDA PANTALLA")
        }

        // 5. Simulación de Toast (Mensaje de error)
        if (showToast) {
            // LaunchedEffect ejecuta un bloque suspendido al entrar en el Composable
            LaunchedEffect(Unit) {
                delay(2000) // Espera 2 segundos
                showToast = false // Desactiva el mensaje
            }
            Text(
                text = "El nombre es obligatorio",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

// --- FIN DEL CODIGO DE LA PANTALLA ---


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplicamos el tema de la aplicación
            // (Asegúrate de que 'HelloWorldTheme' existe en tu proyecto)
            FirstAppTheme {
                // Llamamos a la pantalla principal. Le pasamos el bloque de código
                // que queremos que ejecute cuando esté lista para navegar.
                MainScreen(onNavigate = { name ->
                    // Lógica para lanzar la segunda Activity (usando Intent)
                    val intent = Intent(this, NameActivity::class.java).apply {
                        putExtra("name", name) // Clave: "name", Valor: el nombre ingresado
                    }
                    startActivity(intent)
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FirstAppTheme { // Usa el tema de tu proyecto
        // Pasamos una función vacía {} para satisfacer el requisito de onNavigate
        // Esto es porque no podia hacer una preview de la pantalla principal
        MainScreen(onNavigate = {})
    }
}




