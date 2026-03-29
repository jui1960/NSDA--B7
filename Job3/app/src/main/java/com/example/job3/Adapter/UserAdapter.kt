package com.example.job3.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.job3.Model.AppUser
import com.example.job3.databinding.ItemUserBinding

class UserAdapter(private val userList: List<AppUser>) :
    RecyclerView.Adapter<UserAdapter.viewModel>() {


    inner class viewModel(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewModel {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewModel(binding)
    }

    override fun onBindViewHolder(holder: viewModel, position: Int) {
        val data = userList[position]
        holder.binding.tvUsername.text = data.username
        holder.binding.tvEmail.text = data.email

        holder.binding.tvLat.text = "Lat : ${data.latitude ?: "N/A"}"
        holder.binding.tvLng.text = "Lng : ${data.longitude ?: "N/A"}"

    }

    override fun getItemCount(): Int {
        return userList.size

    }


}