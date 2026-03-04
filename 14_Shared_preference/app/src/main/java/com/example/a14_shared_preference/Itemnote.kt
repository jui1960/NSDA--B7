package com.example.a14_shared_preference

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a14_shared_preference.databinding.ActivityItemnoteBinding

class Itemnote : AppCompatActivity() {
    private lateinit var binding: ActivityItemnoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityItemnoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}