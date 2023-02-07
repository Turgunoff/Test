package com.example.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.model.Offer

class ListAdapter(val items: List<Offer>) :
    RecyclerView.Adapter<ListAdapter.ItemHolder>() {

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvMerchant: TextView = view.findViewById(R.id.tvMerchant)
        val tvBrand: TextView = view.findViewById(R.id.tvBrand)
        val tvCategory: TextView = view.findViewById(R.id.tvCategory)
        val ivImage: ImageView = view.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]

        Glide.with(holder.itemView.context)
            .load(item.image.url).into(holder.ivImage)
        holder.tvName.text = item.name
        holder.tvMerchant.text = item.merchant
        holder.tvBrand.text = item.brand
        holder.tvCategory.text = item.category
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}