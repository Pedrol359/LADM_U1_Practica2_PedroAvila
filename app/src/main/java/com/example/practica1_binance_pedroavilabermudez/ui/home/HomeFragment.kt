package com.example.practica1_binance_pedroavilabermudez.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBindings
import com.example.practica1_binance_pedroavilabermudez.Global
import com.example.practica1_binance_pedroavilabermudez.R
import com.example.practica1_binance_pedroavilabermudez.VenderCriptomonedas
import com.example.practica1_binance_pedroavilabermudez.Wallet
import com.example.practica1_binance_pedroavilabermudez.databinding.FragmentHomeBinding
import java.io.OutputStreamWriter
import java.lang.Exception

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //cargar archivos de memoria interna a memoria ram
        Global.cargarArchivo(requireContext())


        binding.btncomprar.setOnClickListener{
            val wallet = Intent(context, Wallet::class.java)
            startActivity(wallet)


        }


        binding.mercado.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://coinmarketcap.com/es/")
            startActivity(openURL)

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }










}