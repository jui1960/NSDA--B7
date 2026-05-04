package com.example.jui_9_rest01

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.jui_9_rest01.databinding.ProductItemBinding

class ProductAdapter(private val list: List<Product>, private val onClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = list[position]

        holder.binding.productTitle.text = product.title
        holder.binding.productPrice.text = "$" + product.price

        if (product.images.isNotEmpty()) {
            val rawImageUrl = product.images[0]

            val cleanImageUrl = rawImageUrl
                .replace("[", "")
                .replace("]", "")
                .replace("\"", "")

            Glide.with(holder.itemView.context)
                .load(cleanImageUrl)
                .placeholder(android.R.drawable.ic_menu_report_image)
                .error(android.R.drawable.ic_dialog_alert)
                .into(holder.binding.productImage)
        }

        holder.binding.root.setOnClickListener { onClick(product) }
    }
}