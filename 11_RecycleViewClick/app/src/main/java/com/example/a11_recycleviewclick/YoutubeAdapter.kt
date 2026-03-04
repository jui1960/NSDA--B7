package com.example.a11_recycleviewclick

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a11_recycleviewclick.databinding.ActivityDetailsItemBinding
import com.example.a11_recycleviewclick.databinding.ActivityItemListBinding


class YoutubeAdapter(private val youtubeData: List<YoutubeData>) :
    RecyclerView.Adapter<YoutubeAdapter.YoutubeViewHodlder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): YoutubeViewHodlder {
        val binding =
            ActivityItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return YoutubeViewHodlder(binding)
    }

    override fun onBindViewHolder(
        holder: YoutubeViewHodlder,
        position: Int
    ) {
        val data = youtubeData[position]
        holder.binding.itemImg1.setImageResource(data.image)
        holder.binding.logoimg1.setImageResource(data.logoImage)
        holder.binding.videoTitle.text = data.Title


        holder.binding.root.setOnClickListener {
            val context = holder.binding.root.context
            val intent = Intent(context, Details_item::class.java)
            intent.putExtra("image",data.image)
            intent.putExtra("logo", data.logoImage)
            intent.putExtra("descreption",data.Title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
      return youtubeData.size
    }

    inner class YoutubeViewHodlder(val binding: ActivityItemListBinding) :
        RecyclerView.ViewHolder(binding.root)
}