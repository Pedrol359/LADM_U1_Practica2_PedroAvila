package com.example.practica1_binance_pedroavilabermudez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.practica1_binance_pedroavilabermudez.databinding.ActivityCompraCriptoBinding

class CompraCripto : AppCompatActivity() {

    private lateinit var binding: ActivityCompraCriptoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCompraCriptoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = "Criptomonedas"


        val lista = findViewById <ListView>(R.id.lista)
        lista.setOnItemClickListener { adapterView, view, i, l ->
            println(i)
            val vntCantidad_comprar = Intent(this, cantidadCriptos::class.java)
            startActivity(vntCantidad_comprar)
        }

    }


}