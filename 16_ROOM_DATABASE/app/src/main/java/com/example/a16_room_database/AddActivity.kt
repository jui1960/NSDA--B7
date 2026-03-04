package com.example.a16_room_database

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.a16_room_database.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding

    private lateinit var viewModel: NoteViewModel
    private var noteid = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        noteid = intent.getIntExtra("id", -1)

        if (noteid != -1) {
            binding.nameET.setText(intent.getStringExtra("name"))
            binding.addressET.setText(intent.getStringExtra("address"))
            binding.email.setText(intent.getStringExtra("email"))
            binding.ageEt.setText("${intent.getIntExtra("age",0)}")
            binding.phone.setText(intent.getStringExtra("phone"))
        }

        binding.button.setOnClickListener {
            val name = binding.nameET.text.toString()
            val address = binding.addressET.text.toString()
            val email = binding.email.text.toString()
            val age = binding.ageEt.text.toString().toIntOrNull() ?: 0

            val phone = binding.phone.text.toString()

            if (noteid == -1) {
                val note = Note(name = name, address = address, email = email, age = age,phone = phone, )
                viewModel.insertview(note)
            } else {
                val note = Note(id = noteid, name = name, address = address, email = email, age = age, phone = phone,)
                viewModel.updatertview(note)
            }
            Toast.makeText(
                this@AddActivity, "data saved successfully",
                Toast.LENGTH_SHORT
            ).show()
            finish()

        }
    }
}