package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ProductItemBinding

class ProductAdapter(
    private val list: List<Product>,
    private val onItem: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ProductItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = list[position]

        holder.binding.productTitle.text = product.title
        holder.binding.productPrice.text = "$${product.price}"
        holder.binding.productDescription.text = product.description

        holder.binding.root.setOnClickListener {
            onItem(product)
        }



        val imageUrl = product.images.getOrNull(0) ?: ""
        Glide.with(holder.itemView.context)
            .load(product.images[0])
            .placeholder(android.R.drawable.progress_indeterminate_horizontal)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.binding.productImage)


    }

    override fun getItemCount(): Int {
        return list.size
    }
}