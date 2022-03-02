package com.example.practica1_binance_pedroavilabermudez

import android.content.Context
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

object Global { //object funciona como una clase estatica (pero si se puede cambiar los valores)
    var example = "GlobalVars.example"

    //Listas dinamicas
    var criptomoneda= arrayListOf<String>()
    var cantidad= arrayListOf<String>()
    val criptomonedas = arrayOf("Bitcoin","Ethereum","Cardano (ADA)","Tether (USDT)",
        "Binance Coin (BNB)","Ripple (XRP)","Dogecoin (DOGE)","USDCoin (USDC)","Polkadot (DOT)","Solana (SOL)",
        "Litecoin","NEO","IOTA","Chainlink")


    fun guardarArchivo(context:Context){
        try {
            //Borra el archivo
            borrarArchivo(context)
            val archivo = OutputStreamWriter(context.openFileOutput("archivo.txt",Context.MODE_APPEND))
            //vaciar a una variable normal de tipo String
            var cadena=""
            for (i in 0 until criptomoneda.size){
                cadena += criptomoneda.get(i) + "," + cantidad.get(i) + "\n"
            }

            archivo.write(cadena)
            archivo.flush()
            archivo.close()

        }catch (e: Exception){
            Toast.makeText(context,e.message, Toast.LENGTH_LONG)
        }
    }
    fun cargarArchivo(context:Context) {
        try {
            criptomoneda.clear()
            cantidad.clear()

            val archivo =BufferedReader(InputStreamReader(context.openFileInput("archivo.txt")))
            val temp = archivo.readLines()
            var temp2:String
            for(i in temp){
                val temp3 = i.split(",")
                criptomoneda.add(temp3[0])
                cantidad.add(temp3[1])
            }
            println(temp)
            println(criptomoneda)
            println(cantidad)

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG)
        }
    }

    fun borrarArchivo(context:Context){
        try {
            val archivo = OutputStreamWriter(context.openFileOutput("archivo.txt",0))
            archivo.write("")
            archivo.flush()
            archivo.close()
            println(criptomoneda)
            println(cantidad)
        }catch (e: Exception){
            Toast.makeText(context,e.message, Toast.LENGTH_LONG)
        }
    }

    fun guardar(cripto:String, cant:String,context:Context){ // Este metodo Edita o agrega un nuevo elemento al archivo
        if (criptomoneda.size!=0){
            println("!=0")
            var criptoExiste=false
            for (i in 0 until criptomoneda.size){
                println("for")

                if (criptomoneda.get(i).equals(cripto)){
                    println("if")
                    val cantidadActual=cantidad.get(i).toDouble()
                    val cantidadAñadir=cant.toDouble()
                    val nuevaCantidad = cantidadActual+cantidadAñadir
                    if (nuevaCantidad <=0){//Elimina los registros menores o iguales a cero
                        println("Borrar porque: "+nuevaCantidad + " Cantidad: "+cantidad)
                        criptomoneda.removeAt(i)
                        cantidad.removeAt(i)
                        guardarArchivo(context)
                        return
                    }
                    println("Antes de añadir: " + cantidad.size+ " Arreglo Cantidad: "+ cantidad)
                    cantidad.add(i,nuevaCantidad.toString())
                    println("Despues de añadir Sin eliminar el viejo valor: " + cantidad.size + " Arreglo Cantidad: "+ cantidad)
                    cantidad.removeAt(i+1)
                    println("Despues de remover el viejo valor: " + cantidad.size + " Arreglo Cantidad: "+ cantidad)
                    criptoExiste=true
                    guardarArchivo(context)
                    return
                }
            }
            if (!criptoExiste){
                println("no existe")
                criptomoneda.add(cripto)
                cantidad.add(cant)
                criptoExiste=false
                guardarArchivo(context)

                return

            }
        }else// se ejecuta cuando no hay nada
        {
            println("==0")
            criptomoneda.add(cripto)
            cantidad.add(cant)
            guardarArchivo(context)

        }

    }




}