package com.curso.android.module5.aichef.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

object ShareUtils {

    /**
     * Comparte un Bitmap usando el share sheet de Android
     */
    fun shareBitmap(context: Context, bitmap: Bitmap, fileName: String = "recipe_share.png") {
        // 1. Crear archivo temporal en cache
        val cachePath = File(context.cacheDir, "images")
        cachePath.mkdirs()
        val file = File(cachePath, fileName)
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }

        // 2. Convertir a URI usando FileProvider
        val contentUri: Uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider", // Debe coincidir con Manifest
            file
        )

        // 3. Crear Intent para compartir
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, contentUri)
            type = "image/png"
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        // 4. Lanzar chooser
        context.startActivity(Intent.createChooser(shareIntent, "Compartir receta"))
    }
}
