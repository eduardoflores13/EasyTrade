package com.example.easytrade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewParent
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.easytrade.fragments.adapters.intercambiosViewPagerAdapter
import com.example.easytrade.fragments.articuloscambiofragment
import com.example.easytrade.fragments.misarticulosfragment
import com.example.easytrade.modelos.Articulo
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_articuloscambiofragment.*

class intercambios_activity : AppCompatActivity(), ArticuloClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intercambios_activity)

        setUpTabs()

        val btncerrar = findViewById<Button>(R.id.btncerrar)

        btncerrar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }



    }

    private fun setUpTabs(){
        val adapter = intercambiosViewPagerAdapter(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.intercambiosviewpager)
        val tab = findViewById<TabLayout>(R.id.intercambiostab)
        adapter.addFragment(articuloscambiofragment(),"Artículos de cambio")
        adapter.addFragment(misarticulosfragment(),"Mis artículos")
        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)

    }


    override fun articuloClicked(articulo:Articulo){
        //val intentarticulo = Intent(this, detalleArticulo::class.java)
        //intent.putExtra("Articulo", articulo)
        //startActivity(intentarticulo)
    }


}