package com.example.practica1_binance_pedroavilabermudez

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    val titles= arrayOf("Bitcoin","Monkey","Dodgcoin")
    val details= arrayOf("0.25","123","20")
    inner class ViewHolder (itemsView: View):RecyclerView.ViewHolder(itemsView){
        var itemTitle:TextView
        var itemDetails:TextView

        init {
            itemTitle=itemsView.findViewById(R.id.item_title)
            itemDetails=itemsView.findViewById(R.id.description)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i:Int) {
        viewHolder.itemTitle.text=Global.criptomoneda.get(i)
        viewHolder.itemDetails.text="Cantidad: "+Global.cantidad.get(i)
    }

    override fun getItemCount(): Int {
        return Global.criptomoneda.size
    }


}