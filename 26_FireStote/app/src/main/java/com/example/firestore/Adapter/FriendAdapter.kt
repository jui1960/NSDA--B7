package com.example.firestore.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firestore.databinding.ItemBinding

class FriendAdapter() : RecyclerView.Adapter<FriendAdapter.userVidewModel>() {
    inner class userVidewModel(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): userVidewModel {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return userVidewModel(binding)
    }

    override fun onBindViewHolder(
        holder: userVidewModel, position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}