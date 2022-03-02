package com.example.practica1_binance_pedroavilabermudez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class VenderCriptomonedas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vender_criptomonedas)

        val btnComprar = findViewById <Button>(R.id.vender)
        val txtCantidad = findViewById <EditText>(R.id.cantidad)
        val txtStp = findViewById <EditText>(R.id.stp)



        btnComprar.setOnClickListener {
            if (txtCantidad.text.toString().isEmpty() || txtStp.text.toString().isEmpty())
            {
                AlertDialog.Builder(this)
                    .setTitle("Confirmar compra")
                    .setMessage("Por favor, no deje los campos vacios")
                    .show()
                return@setOnClickListener
            }
            AlertDialog.Builder(this)
                .setTitle("Confirmar venta")
                .setMessage("Estas seguro que quieres vender ${txtCantidad.text.toString()} criptomonedas")
                .setPositiveButton("Aceptar",{d,i->
                    AlertDialog.Builder(this)
                        .setMessage("Venta Relaizada con exito")
                        .setTitle("Resultado de transaccion")
                        .setPositiveButton("Aceptar",{d,i->
                            finish()
                        })
                        .show()
                })
                .setNegativeButton("Cancelar",{d,i->})
                .show()
        }
    }
}