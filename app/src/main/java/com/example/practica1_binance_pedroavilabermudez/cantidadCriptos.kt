package com.example.practica1_binance_pedroavilabermudez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.io.OutputStreamWriter

class cantidadCriptos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cantidad_criptos)

        val btnComprar = findViewById <Button>(R.id.comprarCriptos)
        val txtCantidad = findViewById <EditText>(R.id.cantidad)
        val txtTarjeta = findViewById <EditText>(R.id.numeroTarjeta)
        val txtFecha = findViewById <EditText>(R.id.fechaCaducidad)
        val txtCvc = findViewById <EditText>(R.id.codigoCvc)

        btnComprar.setOnClickListener {
            if (txtCantidad.text.toString().isEmpty() ||
                txtTarjeta.text.toString().isEmpty() ||
                txtFecha.text.toString().isEmpty() ||
                txtCvc.text.toString().isEmpty())
            {

                AlertDialog.Builder(this)
                    .setTitle("Confirmar compra")
                    .setMessage("Por favor, no deje los campos vacios")
                    .show()
                return@setOnClickListener
            }
                    AlertDialog.Builder(this)
                        .setTitle("Confirmar compra")
                        .setMessage("Estas seguro que quieres comprar ${txtCantidad.text.toString()} criptos")
                        .setPositiveButton("Aceptar",{d,i->
                            AlertDialog.Builder(this)
                                .setMessage("Compra Relaizada con exito")
                                .setTitle("Resultado de transaccion")
                                .setPositiveButton("Aceptar",{d,i->
                                    finish()
                                })
                                .show()
                        })
                        .setNegativeButton("Cancelar",{d,i->})
                        .show()
        }

        fun guardarCompra(criptos:Double){
            try {
                val archivo = OutputStreamWriter(openFileOutput("wallet.bit", MODE_PRIVATE))
                archivo.write("${criptos}\n")
            }catch (e:Exception){
                Toast.makeText(this,e.message,Toast.LENGTH_LONG)
            }
        }
        fun guardarTarjeta(tarjeta:String,fecha:String,cvc:Int){
            try {
                val archivo = OutputStreamWriter(openFileOutput("infoTarjeta.txt", MODE_PRIVATE))

            }catch (e:Exception){
                Toast.makeText(this,e.message,Toast.LENGTH_LONG)
            }
        }
    }

}