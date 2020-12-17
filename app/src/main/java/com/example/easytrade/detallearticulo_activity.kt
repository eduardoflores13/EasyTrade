package com.example.easytrade
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.easytrade.fragments.adapters.detallearticuloViewPagerAdapter
import com.example.easytrade.fragments.detallearticulofragment
import com.example.easytrade.fragments.ofertasrecibidasfragment
import com.google.android.material.tabs.TabLayout


class detallearticulo_activity : AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.detallearticulo_activity)

            setUpTabs()
        }
    private fun setUpTabs(){
        val adapter = detallearticuloViewPagerAdapter(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.intercambiosviewpager)
        val tab = findViewById<TabLayout>(R.id.articulostab)
        adapter.addFragment(detallearticulofragment(),"Artículos de cambio")
        adapter.addFragment(ofertasrecibidasfragment(),"Ofertas Recibidas")
        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)

    }
    }
