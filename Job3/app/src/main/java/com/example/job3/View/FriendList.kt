package com.example.job3.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.job3.R
import com.example.job3.databinding.ActivityFriendListBinding
import com.example.job3.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class FriendList : AppCompatActivity() {
    private lateinit var binding: ActivityFriendListBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFriendListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


    }
}