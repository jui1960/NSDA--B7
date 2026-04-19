package com.example.locationapp.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.locationapp.R
import com.example.locationapp.databinding.ActivityFriendListBinding

class FriendList : AppCompatActivity() {
    private lateinit var binding: ActivityFriendListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFriendListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val density = resources.displayMetrics.density
            val padding16dp = (16 * density).toInt()

            v.setPadding(
                padding16dp,
                systemBars.top + padding16dp,
                padding16dp,
                systemBars.bottom + padding16dp
            )
            insets
        }

    }
}