package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var linkcuenta:TextView = findViewById(R.id.linkcuenta)
        linkcuenta.setText(R.string.cuenta)
        val intentCrearCuenta = Intent(this, crearcuenta_activity::class.java)

        linkcuenta.setOnClickListener {
            linkcuenta.setText(R.string.cuentau)
            startActivity(intentCrearCuenta)

        }
    }
}