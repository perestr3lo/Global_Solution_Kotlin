package com.example.ocean20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ocean20.R
import com.example.ocean20.model.BeachModel

class BeachAdapter : RecyclerView.Adapter<BeachAdapter.ItemViewHolder>() {

    private var items = listOf<BeachModel>()

    fun updateItems(newItems: List<BeachModel>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.beach_layout, parent, false)
        return ItemViewHolder(view)
    }
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewPraia = view.findViewById<TextView>(R.id.textViewPraia)
        val textViewCidade = view.findViewById<TextView>(R.id.textViewCidade)
        val textViewEstado = view.findViewById<TextView>(R.id.textViewEstado)
        val button = view.findViewById<Button>(R.id.btnDelete)
        fun bind(item: BeachModel) {
            textViewPraia.text = item.nameBeach
            textViewCidade.text = item.nameCity
            textViewEstado.text = item.nameState
            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}