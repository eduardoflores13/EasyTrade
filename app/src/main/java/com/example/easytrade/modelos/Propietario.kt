package com.example.easytrade.modelos

import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.android.parcel.Parcelize


@Parcelize
@IgnoreExtraProperties

data class Propietario(
    var idPropietario: Int? = 0,
    var nombrePropietario: String?="",
    var apellidoPropietario: String?="",
    var telefonoPropietario: String?="",
    )   : Parcelable {

        @Exclude
        fun toMap(): Map<String, Any?>{
            return mapOf(
            "idPropietario" to idPropietario,
            "nombrePropietario" to nombrePropietario,
            "apellidoPropietario" to apellidoPropietario,
            "telefonoPropietario" to telefonoPropietario
            )
        }
    }