package com.example.a16_room_database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a16_room_database.databinding.ActivityItemNoteBinding


class NoteAdapter(
    private val list: List<Note>,
    private val onedit: (Note) -> Unit,
    private val ondelete: (Note) -> Unit,
    private val onitem : (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.viewHolder>() {


    inner class viewHolder(val binding: ActivityItemNoteBinding)
        :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {
        val binding =
            ActivityItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: viewHolder,
        position: Int
    ) {
        val note = list[position]
        holder.binding.name.text = note.name
        holder.binding.address.text = note.address
        holder.binding.email.text = note.email
        holder.binding.age.text=note.age.toString()
        holder.binding.phone.text = note.phone
        holder.binding.editBtn.setOnClickListener {
            onedit(note)
        }
        holder.binding.deleteBtn.setOnClickListener {
            ondelete(note)

        }
        holder.binding.root.setOnClickListener {
            onitem(note)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}