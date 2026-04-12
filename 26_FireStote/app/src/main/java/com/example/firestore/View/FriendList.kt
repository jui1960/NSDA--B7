package com.example.firestore.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firestore.databinding.ActivityFriendListBinding

class FriendList : AppCompatActivity() {
    private lateinit var binding: ActivityFriendListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFriendListBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}