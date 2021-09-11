package com.lzitech.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lzitech.myapplication.Item
import com.lzitech.myapplication.R

class ItemAdapter(private val itemsList: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.iv_icon)
        val tvFirstTitle: TextView = itemView.findViewById(R.id.tv_title);
        val tvSecondTitle: TextView = itemView.findViewById(R.id.tv_second_title);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.todo_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem : Item = itemsList.get(position)
        holder.image.setImageResource(currentItem.icon)
        holder.tvFirstTitle.text = currentItem.title1
        holder.tvSecondTitle.text = currentItem.title2

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}