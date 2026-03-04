package com.example.a15_sharedpreference_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a15_sharedpreference_recyclerview.databinding.ActivityItemNoteBinding

class NoteAdapter(private val notelist: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.Noteviewholder>() {

    inner class Noteviewholder(val binding: ActivityItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Noteviewholder {
        val binding =
            ActivityItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Noteviewholder(binding)
    }
    override fun onBindViewHolder(
        holder: Noteviewholder,
        position: Int
    ) {
        holder.binding.txtItemNote.text = notelist[position].text

    }

    override fun getItemCount(): Int {
        return notelist.size
    }

}