package com.example.practica1_binance_pedroavilabermudez.ui.slideshow

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBindings
import com.example.practica1_binance_pedroavilabermudez.Global
import com.example.practica1_binance_pedroavilabermudez.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    //Variable global
    var index=0
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Llenar el spinner con las criptos que tiene
        val adaptador = ArrayAdapter<String>(requireContext(), R.layout.simple_spinner_dropdown_item,
            Global.criptomoneda)
        binding.spinner.adapter = adaptador




        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context!!, "onNothingSelected", Toast.LENGTH_SHORT).show()
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Toast.makeText(requireContext(), "onItemSelected position: $position. id: $id", Toast.LENGTH_SHORT).show()
                println("Pos: "+position)
                index=position
            }
        }


        binding.vender.setOnClickListener {

            if (Global.criptomoneda.size==0){
                AlertDialog.Builder(requireContext()).setTitle("Resultado de la venta")
                    .setMessage("No tienes criptomonedas para vender").setPositiveButton("Aceptar",{d,i->})
                    .show()
                return@setOnClickListener
            }
            if (binding.cantidad.text.toString().isEmpty() || binding.stp.text.toString().isEmpty())
            {
                AlertDialog.Builder(requireContext())
                    .setTitle("Confirmar venta")
                    .setMessage("Por favor, no deje los campos vacios")
                    .show()
                return@setOnClickListener
            }
            val cantidadActual=Global.cantidad.get(index).toDouble()-binding.cantidad.text.toString().toDouble()
            if ( cantidadActual<0){
                AlertDialog.Builder(requireContext()).setTitle("Resultado de la venta")
                    .setMessage("No tiene la cantidad de ${Global.criptomoneda.get(index)} " +
                            "que quiere vender\nCantidad Actual: ${Global.cantidad.get(index)}\n" +
                            " Cantidad a vender: ${binding.cantidad.text.toString()}")
                    .setPositiveButton("Aceptar",{d,i->})
                    .show()
                return@setOnClickListener
            }
            println("Cantidad Actual: "+cantidadActual)
            AlertDialog.Builder(requireContext())
                .setTitle("Confirmar venta")
                .setMessage("Estas seguro que quieres vender ${binding.cantidad.text.toString()} criptomonedas de ${Global.cantidad.get(index)}")
                .setPositiveButton("Aceptar",{d,i->
                    Global.guardar(Global.criptomoneda.get(index),"-"+binding.cantidad.text.toString(),requireContext())
                    AlertDialog.Builder(requireContext())
                        .setMessage("Venta Relaizada con exito")
                        .setTitle("Resultado de transaccion")
                        .setPositiveButton("Aceptar",{d,i->})
                        .show()
                })
                .setNegativeButton("Cancelar",{d,i->})
                .show()
        }


        /*val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}