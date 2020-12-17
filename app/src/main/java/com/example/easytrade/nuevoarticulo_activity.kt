package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.easytrade.modelos.Articulo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.nuevoarticulo_activity.*
import java.util.*

class nuevoarticulo_activity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseDatabase
    private lateinit var articulosRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nuevoarticulo_activity)

        db = FirebaseDatabase.getInstance()
        articulosRef = db.getReference("articulos")

        val botonNuevo = findViewById<Button>(R.id.btnguardar3)
        val telefonos = arrayListOf<String>("https://http2.mlstatic.com/D_NQ_NP_893143-MLA41829150631_052020-O.jpg",
                "https://www.macstore.com.pa/wp-content/uploads/2020/02/MQ8P2LZ-1.jpg",
                "https://media2.stuyomovil.com/235-large_default/samsung-galaxy-a71-6-128gb-sma715-negro.jpg",
                "https://consumer-img.huawei.com/content/dam/huawei-cbg-site/common/mkt/pdp/phones/mate20-lite/img/huawei_mate20lite_color_blue.jpg",
                "https://cdn.dxomark.com/wp-content/uploads/2018/01/galaxys7edge-1024x768.png",
                "https://www.giztop.com/media/catalog/product/cache/dc206057cdd42d7e34b9d36e347785ca/x/i/xiaomi_mi_note_10_pro-.png"
            )

        botonNuevo.setOnClickListener {
            val nombreproducto = txtnombre4.text
            val descripcion = txtdescripcion2.text
            val articulo = Articulo()
            val random = Random()
            val numfoto = random.nextInt(5)
            articulo.idArticulo = 3
            articulo.idPropietario = 2
            articulo.descripcionArticulo = descripcion.toString()
            articulo.nombreArticulo = nombreproducto.toString()
            articulo.urlfoto = telefonos[numfoto]

            articulosRef.push().setValue(articulo)
            Toast.makeText(this, "El articulo ha sido creado exitosamente", Toast.LENGTH_LONG).show()
            txtnombre4.setText(" ")
            txtdescripcion2.setText(" ")
        }
    }

}