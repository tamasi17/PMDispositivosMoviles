package com.example.oopkotlin.models

// 1. Import everything needed for Jetpack Compose drawing
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color // Use the Compose Color


// 2. Define the Square class that holds the data
// It's good practice to make this a data class
data class Square(val x: Float, val y: Float, val size: Float)

// 3. Define the Composable function that knows how to draw a Square
@Composable
fun SquareComposable(modifier: Modifier = Modifier) {


    // Create an instance of your Square class
    val squareSize = 200f

    // Use the Jetpack Compose Canvas
    Canvas(modifier = modifier) {

        val centerX = center.x
        val centerY = center.y

        val topLeftX = centerX - (squareSize / 2)
        val topLeftY = centerY - (squareSize / 2)

        drawRect(
            color = Color.Cyan,
            topLeft = Offset(topLeftX, topLeftY),
            size = Size(squareSize, squareSize)
        )
    }


}