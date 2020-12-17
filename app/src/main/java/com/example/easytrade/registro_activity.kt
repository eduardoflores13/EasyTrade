package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class registro_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_activity)

        val btninicio = findViewById<Button>(R.id.btnguardar)
        val intentArticulos = Intent(this, intercambios_activity::class.java)

        btninicio.setOnClickListener {
            startActivity(intentArticulos)
            finish()
        }
    }
}