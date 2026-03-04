package com.example.a6_studyplan_app_design

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a6_studyplan_app_design.databinding.ActivityFriendListScreenBinding
import com.example.a6_studyplan_app_design.databinding.ActivityMainBinding
import com.example.a6_studyplan_app_design.databinding.ActivitySignUpScreenBinding

class friend_list_screen : AppCompatActivity() {
    private lateinit var binding : ActivityFriendListScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFriendListScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backwlcId.setOnClickListener {
            startActivity(Intent(this@friend_list_screen, MainActivity::class.java))
        }
    }
}