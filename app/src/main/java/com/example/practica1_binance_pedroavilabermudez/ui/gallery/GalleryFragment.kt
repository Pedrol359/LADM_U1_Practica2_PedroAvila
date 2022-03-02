package com.example.practica1_binance_pedroavilabermudez.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practica1_binance_pedroavilabermudez.Global
import com.example.practica1_binance_pedroavilabermudez.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //Variables
    var index=0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
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

        binding.comprarCriptos.setOnClickListener {
            if (binding.cantidad.text.toString().isEmpty() ||
                binding.numeroTarjeta.text.toString().isEmpty() ||
                binding.fechaCaducidad.text.toString().isEmpty() ||
                binding.codigoCvc.text.toString().isEmpty())
            {

                AlertDialog.Builder(requireContext())
                    .setTitle("Confirmar compra")
                    .setMessage("Por favor, no deje los campos vacios")
                    .show()
                return@setOnClickListener
            }
            AlertDialog.Builder(requireContext())
                .setTitle("Confirmar compra")
                .setMessage("Estas seguro que quieres comprar ${binding.cantidad.text.toString()} criptos")
                .setPositiveButton("Aceptar",{d,i->
                    //Guardar bitcoins

                    Global.guardar(Global.criptomonedas[index],binding.cantidad.text.toString(),requireContext())


                    AlertDialog.Builder(requireContext())
                        .setMessage("Compra Relaizada con exito")
                        .setTitle("Resultado de transaccion")
                        .setPositiveButton("Aceptar",{d,i->
                            //finish()
                            /*binding.cantidad.setText("")
                            binding.numeroTarjeta. setText("")
                            binding.fechaCaducidad.setText("")
                            binding.codigoCvc.setText("")*/
                        })
                        .show()
                })
                .setNegativeButton("Cancelar",{d,i->})
                .show()


        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}