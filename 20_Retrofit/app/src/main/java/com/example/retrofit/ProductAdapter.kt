package com.example.retrofit

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.databinding.ProductItemBinding

class ProductAdapter(
    private val list: List<Product>,
    private val onItem: (Product) -> Unit
) :
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
        holder.binding.productDescription.text = product.description
        holder.binding.productCategory.text = product.category

        holder.binding.tvRatingRate.text = product.rating.rate.toString()
        holder.binding.tvRatingCount.text = "(${product.rating.count})"


        holder.binding.root.setOnClickListener {
            onItem(product)
        }

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.binding.productImage)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}