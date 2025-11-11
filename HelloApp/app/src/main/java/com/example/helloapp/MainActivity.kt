package com.example.helloapp

// AndroidStudio marca por defecto el uso de Jetpack Compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloapp.ui.theme.HelloAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloAppTheme {
                // Llamamos a la función Composable que muestra el mensaje
                HelloWorld()

            }
        }
    }
}

@Composable
fun HelloWorld() {
    var message by remember { mutableStateOf("Hello wooorld") }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text=message)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            message = "Texto cambiado!"})
        {
            Text("Cambiar texto")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloAppTheme {
        HelloWorld()
    }
}
