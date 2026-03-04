package com.example.a15_sharedpreference_recyclerview

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a15_sharedpreference_recyclerview.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharepref: SharedPreferences
    private val notlist = mutableListOf<Note>()
    private lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharepref = getSharedPreferences("note_pref", MODE_PRIVATE)
        adapter = NoteAdapter(notlist)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter


        binding.editNote.setText(
            sharepref.getString("draft_text", "")
        )
        binding.editNote.addTextChangedListener {
            sharepref.edit { putString("draft_text", it.toString()) }
        }
        loadNotes()

        binding.btnAdd.setOnClickListener {
            val text = binding.editNote.text.toString()

            if (text.isNotEmpty()) {
                notlist.add(Note(text))
                saveNote()
                adapter.notifyDataSetChanged()

                binding.editNote.text?.clear()

                sharepref.edit {
                    remove("draft_text")
                }
            }
        }


    }

    private fun saveNote() {
        val gson = Gson()
        val json = gson.toJson(notlist)

        sharepref.edit {
            putString("notes", json)
        }
    }

    private fun loadNotes() {
        val gson = Gson()
        val json = sharepref.getString("notes", null)

        val type = object : TypeToken<MutableList<Note>>() {}.type

        val savedList: MutableList<Note>? = gson.fromJson(json, type)
        if (savedList != null) {
            notlist.addAll(savedList)
        }
    }


}
