package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class crearcuenta_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crearcuenta_activity)
        val iniciosesion:TextView = findViewById(R.id.txviniciarsesion)
        val registro:TextView = findViewById(R.id.btncrearcuenta)

        val intentCrear = Intent(this, registro_activity::class.java)

        iniciosesion.setOnClickListener {
            onBackPressed()
        }

        registro.setOnClickListener {
            startActivity(intentCrear)
        }

    }
}