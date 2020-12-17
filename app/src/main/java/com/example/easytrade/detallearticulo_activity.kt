package com.example.easytrade
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.easytrade.fragments.adapters.detallearticuloViewPagerAdapter
import com.example.easytrade.fragments.detallearticulofragment
import com.example.easytrade.fragments.ofertasrecibidasfragment
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detallearticulo_activity.*


class detallearticulo_activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detallearticulo_activity)

        setUpTabs()

        var nombre = intent.getStringExtra("nombre")
        var descripcion = intent.getStringExtra("descripcion")
        var urlfoto = intent.getStringExtra("urlfoto")
        var idpropietario = intent.getStringExtra("idpropietario")
        var idarticulo = intent.getStringExtra("idarticulo")

        txvnombrearticulo.text = nombre.toString()
        txvdescripcion.text = descripcion.toString()
        Picasso.get().load(urlfoto).into(imageView)

    }


    private fun setUpTabs(){
        val adapter = detallearticuloViewPagerAdapter(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.articulosviewpager)
        val tab = findViewById<TabLayout>(R.id.articulostab)
        adapter.addFragment(detallearticulofragment(),"Ofrecido a")
        adapter.addFragment(ofertasrecibidasfragment(),"Ofertas Recibidas")
        viewPager.adapter = adapter
        tab.setupWithViewPager(viewPager)
    }
}
