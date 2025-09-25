package com.example.practicauno.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.practicauno.R

class ListAdapter(private val items: List<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemText = items[position]
        holder.textView.text = itemText
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Pulsado: $itemText", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = items.size
}