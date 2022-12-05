package com.example.listfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listfragment.databinding.ListItemBinding

class RViewAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<RViewAdapter.RViewHolder>() {

    inner class RViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return RViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        holder.binding.apply {
            tvTextTitle.text = items[position].title
            cbItemCheck.isChecked = items[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}