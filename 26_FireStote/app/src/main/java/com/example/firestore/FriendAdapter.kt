package com.example.firestore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firestore.databinding.ItemBinding

class FriendAdapter(
    private val list: ArrayList<Friend>,
    private val onDelete: (Friend) -> Unit
) :
    RecyclerView.Adapter<friendViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): friendViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return friendViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: friendViewHolder,
        position: Int
    ) {
        val data = list[position]
        holder.binding.tvName.text = data.name
        holder.binding.tvEmail.text = data.email

        holder.binding.btnDelete.setOnClickListener {
            onDelete(data)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class friendViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)