package com.example.practica1_binance_pedroavilabermudez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Wallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_wallet)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter=CustomAdapter()

        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter

    }
}