package com.example.firestore.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firestore.R
import com.example.firestore.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMyProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}