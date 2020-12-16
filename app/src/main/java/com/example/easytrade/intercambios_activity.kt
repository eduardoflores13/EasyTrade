package com.example.easytrade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewParent
import androidx.viewpager.widget.ViewPager
import com.example.easytrade.fragments.adapters.intercambiosViewPagerAdapter
import com.example.easytrade.fragments.articuloscambiofragment
import com.example.easytrade.fragments.misarticulosfragment
import com.google.android.material.tabs.TabLayout

class intercambios_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intercambios_activity)

        setUpTabs()
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
}