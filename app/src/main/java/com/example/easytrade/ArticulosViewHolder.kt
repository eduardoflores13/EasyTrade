package com.example.easytrade

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticulosViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val nombreArticulo = itemView.findViewById<TextView>(R.id.txtnombreproduct)
    val descripcionArticulo = itemView.findViewById<TextView>(R.id.txtdescripcion)
    val foto = itemView.findViewById<ImageView>(R.id.imvproducto)
}