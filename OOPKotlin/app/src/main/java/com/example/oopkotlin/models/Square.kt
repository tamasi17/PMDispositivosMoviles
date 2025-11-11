package com.example.oopkotlin.models

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class Rectangulo(var x: Float, var y: Float, var size: Float) {

    private val paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    fun draw(canvas: Canvas) {
        val rect = RectF(x, y, x + size, y + size)
        canvas.drawRect(rect, paint)
    }

}