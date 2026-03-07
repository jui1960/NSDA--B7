package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.retrofit.databinding.ProductItemBinding

class ProductAdapter(private val list: List<com.example.retrofit.Product>) :
    RecyclerView.Adapter<ProductAdapter.viewHolder>() {
    inner class viewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: viewHolder,
        position: Int
    ) {
        val product = list[position]
        holder.binding.productTitle.text = product.title
        holder.binding.productPrice.text = "$" + product.price

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.binding.productImage)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}