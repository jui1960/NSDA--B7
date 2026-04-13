package com.example.firestore.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firestore.Model.AppUser
import com.example.firestore.databinding.ItemUserBinding


class FriendAdapter(private val onItemClick: (AppUser) -> Unit) :
    ListAdapter<AppUser, FriendAdapter.UserViewModel>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AppUser>() {
            override fun areItemsTheSame(
                oldItem: AppUser,
                newItem: AppUser
            ) = oldItem.userid == newItem.userid

            override fun areContentsTheSame(
                oldItem: AppUser,
                newItem: AppUser
            ) = oldItem == newItem
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewModel {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewModel(binding)
    }

    override fun onBindViewHolder(
        holder: UserViewModel,
        position: Int
    ) {
        val user = getItem(position)
        holder.binding.tvUsername.text = user.userName
        holder.binding.tvEmail.text = user.email
        holder.binding.tvLat.text = "Latitude: ${user.latitude ?: "N/A"}"
        holder.binding.tvLng.text = "Lngitude: ${user.longitude ?: "N/a"}"
        holder.itemView.setOnClickListener {
            onItemClick(user)
        }
    }

    inner class UserViewModel(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root)
}