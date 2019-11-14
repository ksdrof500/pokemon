package com.br.pokemonfinder.util.extensions

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import java.io.ByteArrayOutputStream

fun View.toByteArray(): ByteArray {
    val returnedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(returnedBitmap)

    draw(canvas)

    val stream = ByteArrayOutputStream()
    returnedBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)

    return stream.toByteArray()
}