package com.example.a16_room_database

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a16_room_database.databinding.ActivitySingleProfileBinding

class singleProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySingleProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val id = intent.getIntExtra("id", -1)
        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val email = intent.getStringExtra("email")
        val age = intent.getIntExtra("age", 0)
        val phone = intent.getStringExtra("phone")


        binding.apply {
            detailsName.text = name
            detailsAddress.text=address
            detailsEmail.text=email
            detailsAge.text =age.toString()
            detailsPhone.text= phone
        }
    }
}