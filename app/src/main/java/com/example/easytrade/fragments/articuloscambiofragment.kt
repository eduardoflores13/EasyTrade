package com.example.easytrade.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easytrade.ArticuloClickListener
import com.example.easytrade.ArticulosRecyclerViewAdapter
import com.example.easytrade.R
import com.example.easytrade.intercambios_activity
import com.example.easytrade.modelos.Articulo
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_articuloscambiofragment.*


class articuloscambiofragment : Fragment(), ArticuloClickListener {

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

        var retorno = inflater.inflate(R.layout.fragment_articuloscambiofragment, container, false)
        val adaptador = ArticulosRecyclerViewAdapter(ArrayList<Articulo>(),this)
        val recycler = retorno.findViewById<RecyclerView>(R.id.rcvcambios)

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
                    val adapter = ArticulosRecyclerViewAdapter(artDat, this@articuloscambiofragment)
                    rcvcambios.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("No se que contexto debe ir")
            }

        }
        articulosRef.addValueEventListener(listener)
    }

    override fun articuloClicked(articulo: Articulo) {
        TODO("Not yet implemented")
    }

}