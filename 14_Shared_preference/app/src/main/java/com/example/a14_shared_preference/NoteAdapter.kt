package com.example.a14_shared_preference

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a14_shared_preference.databinding.ActivityItemnoteBinding

class NoteAdapter(private val noteList: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViwHolder>() {

    inner class NoteViwHolder(val binding: ActivityItemnoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViwHolder {
        val binding= ActivityItemnoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteViwHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViwHolder, position: Int) {

        holder.binding.txtItemNote.text =noteList[position].text

    }

    override fun getItemCount(): Int = noteList.size


}