package com.example.easytrade.modelos

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Articulo(
    var idPropietario: Int? = 0,
    var idArticulo: Int? = 0,
    var nombreArticulo: String? = "",
    var descripcionArticulo: String? = "",
    var urlfoto: String? = ""
) {
    @Exclude
    fun toMap():Map<String, Any?>{
        return mapOf(
            "idPropietario" to idPropietario,
            "idArticulo" to idArticulo,
            "nombreArticulo" to nombreArticulo,
            "descripcionArticulo" to descripcionArticulo,
            "urlfoto" to urlfoto
        )
    }
}