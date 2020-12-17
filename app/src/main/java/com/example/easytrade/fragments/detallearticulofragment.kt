package com.example.easytrade.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easytrade.ArticuloClickListener
import com.example.easytrade.ArticulosRecyclerViewAdapter
import com.example.easytrade.R
import com.example.easytrade.detallearticulo_activity
import com.example.easytrade.modelos.Articulo
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_articuloscambiofragment.*
import kotlinx.android.synthetic.main.fragment_detallearticulofragment.*


class detallearticulofragment : Fragment(), ArticuloClickListener {

    private lateinit var db: FirebaseDatabase
    private lateinit var articulosRef: DatabaseReference


    val TAG = "EasyTrade"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var retorno = inflater.inflate(R.layout.fragment_detallearticulofragment, container, false)
        val adaptador = ArticulosRecyclerViewAdapter(ArrayList<Articulo>(),this)
        val recycler = retorno.findViewById<RecyclerView>(R.id.rcvdetallearticulos)

        db = FirebaseDatabase.getInstance()
        articulosRef = db.getReference("articulos")
        agregarListenerArticulos()

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adaptador
        // Inflate the layout for this fragment
        return retorno
    }

    fun agregarListenerArticulos(){
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val datos = snapshot.children
                datos?.let {
                    val artDat = ArrayList<Articulo>()
                    for (dat in datos){
                        val articulo = dat.getValue(Articulo::class.java)

                        articulo?.let {
                            artDat.add(articulo)
                        }
                    }
                    val adapter = ArticulosRecyclerViewAdapter(artDat, this@detallearticulofragment)
                    rcvdetallearticulos.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Hay que ver que context usar, no funciona this, ni context")
            }

        }
        articulosRef.addValueEventListener(listener)
    }

    override fun articuloClicked(articulo: Articulo) {
        val intent = Intent(context, detallearticulo_activity::class.java)
        intent.putExtra("nombre", articulo.nombreArticulo)
        intent.putExtra("descripcion", articulo.descripcionArticulo)
        intent.putExtra("urlfoto",articulo.urlfoto)
        intent.putExtra("idpropietario", articulo.idPropietario)
        intent.putExtra("idarticulo", articulo.idArticulo)
        startActivity(intent)
    }


}