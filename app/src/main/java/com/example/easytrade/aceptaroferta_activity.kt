package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.aceptaroferta_activity.*
import kotlinx.android.synthetic.main.detallearticulo_activity.*

class aceptaroferta_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aceptaroferta_activity)

        var nombrearticulo = intent.getStringExtra("nombre")
        var descripcion = intent.getStringExtra("descripcion")
        var urlfoto = intent.getStringExtra("urlfoto")

        txvnombrearticulo3.setText(nombrearticulo)
        txvdescripcion3.setText(descripcion)
        Picasso.get().load(urlfoto).into(articulo3)

        val aceptar:TextView = findViewById(R.id.btnaceptar)
        val negar:TextView = findViewById(R.id.btnnegar)




        aceptar.setOnClickListener {
            val intentAceptar = Intent(this, informacioncontacto_activity::class.java)
            startActivity(intentAceptar)
        }

        negar.setOnClickListener {
            onBackPressed()
        }
    }
}