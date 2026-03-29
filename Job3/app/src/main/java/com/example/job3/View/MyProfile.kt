package com.example.job3.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.job3.R
import com.example.job3.databinding.ActivityFriendListBinding

class MyProfile : AppCompatActivity() {
    private lateinit var binding: ActivityFriendListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFriendListBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}