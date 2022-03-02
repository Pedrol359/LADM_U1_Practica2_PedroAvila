package com.example.practica1_binance_pedroavilabermudez

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.practica1_binance_pedroavilabermudez.ui.login.LoginActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCompras =findViewById<Button>(R.id.btncomprar)
        val btnVender =findViewById<Button>(R.id.vender)
        val btnEstadisticas =findViewById<Button>(R.id.mercado)
        btnCompras.setOnClickListener{
            //vntComprar()
            val vnt_vender = Intent(this, Navigation::class.java)
            startActivity(vnt_vender)
        }

        btnVender.setOnClickListener{
            vntVender()

        }

        btnEstadisticas.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://coinmarketcap.com/es/")
            startActivity(openURL)

        }




    }

    fun vntComprar(){
        val intento1 = Intent(this, CompraCripto::class.java)
        startActivity(intento1)

    }

    fun vntVender(){
        val vnt_vender = Intent(this, VenderCriptomonedas::class.java)
        startActivity(vnt_vender)

    }

}