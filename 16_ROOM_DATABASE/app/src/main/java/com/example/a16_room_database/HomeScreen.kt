package com.example.a16_room_database

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.a16_room_database.databinding.ActivityHomeScreenBinding
import com.example.a16_room_database.databinding.ActivityMainBinding
import com.example.a16_room_database.databinding.DialogBinding

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    private lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        viewModel.liveData.observe(this) { list ->
            binding.cnt.text = "Note count : ${list.size}"
            val adapter = NoteAdapter(
                list,
                onedit = { note ->
                    val intent = Intent(this@HomeScreen, AddActivity::class.java)
                    intent.putExtra("id", note.id)
                    intent.putExtra("name", note.name)
                    intent.putExtra("address", note.address)
                    intent.putExtra("email", note.email)
                    intent.putExtra("age", note.age)
                    intent.putExtra("phone", note.phone)
                    startActivity(intent)
                },
                ondelete = { note ->
                    val dialogBinding = DialogBinding.inflate(layoutInflater)
                    val dialog = AlertDialog.Builder(this)
                        .setView(dialogBinding.root)
                        .create()

                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                        dialogBinding.btnConfirm.setOnClickListener {
                            viewModel.deleteview(note)
                            dialog.dismiss()

                        }
                    dialogBinding.btnCancel.setOnClickListener {
                        dialog.dismiss()
                    }
                    dialog.show()


                },
                onitem = { note->
                    val intent = Intent(this@HomeScreen, singleProfileActivity::class.java)
                    intent.putExtra("id", note.id)
                    intent.putExtra("name", note.name)
                    intent.putExtra("address", note.address)
                    intent.putExtra("email", note.email)
                    intent.putExtra("age", note.age)
                    intent.putExtra("phone", note.phone)
                    startActivity(intent)
                }
            )
            binding.recyclerView.adapter = adapter
        }



    }

    override fun onResume() {
        super.onResume()
        viewModel.loadnoteviewModel()
    }

}