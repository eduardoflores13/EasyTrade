package com.example.easytrade

import com.example.easytrade.modelos.Articulo
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.google.firebase.database.DataSnapshot
import com.squareup.picasso.Picasso



class MisArticulosRecyclerViewAdapter(val articulos: ArrayList<Articulo>, val listener: ArticuloClickListener) : Adapter<ArticulosViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticulosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.articulos_view_holder,parent,false)
        return ArticulosViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticulosViewHolder, position: Int) {

        val articulo = articulos[position]
        holder.nombreArticulo.text = articulo?.nombreArticulo.toString()
        holder.descripcionArticulo.text = articulo?.descripcionArticulo.toString()
        Picasso.get().load(articulo.urlfoto).into(holder.foto)
        holder.itemView.setOnClickListener {
            listener.articuloClicked(articulo)
        }

    }

    override fun getItemCount(): Int {
        return articulos.count()
    }

    fun agregarArticulo(articulo:Articulo){
        articulos.add(articulo)
        notifyItemInserted(articulos.size-1)
    }
}