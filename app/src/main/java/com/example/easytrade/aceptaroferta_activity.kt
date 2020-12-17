package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class aceptaroferta_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aceptaroferta_activity)
        val aceptar:TextView = findViewById(R.id.btnaceptar)
        val negar:TextView = findViewById(R.id.btnnegar)

        val intentAceptar = Intent(this, informacioncontacto_activity::class.java)
        val intentNegar = Intent(this, ofertasrecibidas_activity::class.java)

        aceptar.setOnClickListener {
            startActivity(intentAceptar)
        }

        negar.setOnClickListener {
            startActivity(intentNegar)
        }
    }
}