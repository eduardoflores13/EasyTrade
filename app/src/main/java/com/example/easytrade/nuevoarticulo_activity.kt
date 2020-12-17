package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.nuevoarticulo_activity.*

class nuevoarticulo_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nuevoarticulo_activity)

        val botonNuevo = findViewById<Button>(R.id.btnguardar3)
        val btnseleccionar = findViewById<Button>(R.id.btnseleccionar)

        btnseleccionar.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
            }
        }

        botonNuevo.setOnClickListener {
            val nombreproducto = txtnombre4.text

        }
    }

    companion object {
        private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    }
}