package com.example.a11_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a11_recyclerview.databinding.ActivityItemListBinding

class FriendAdapter(
    private val friendlist: List<Friend>
) : RecyclerView.Adapter<FriendAdapter.FriendViewholder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FriendViewholder {
        val binding =
            ActivityItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendViewholder(binding)
    }

    override fun onBindViewHolder(
        holder: FriendViewholder,
        position: Int
    ) {
        val friend = friendlist[position]
        holder.binding.NameTV.text = friend.name
        holder.binding.descriptionTv.text = friend.descreption
        holder.binding.ProfileCIV.setImageResource(friend.img)
    }

    override fun getItemCount(): Int {
        return friendlist.size
    }

    inner class FriendViewholder(val binding: ActivityItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


}