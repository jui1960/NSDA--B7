package com.example.a6_studyplan_app_design

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a6_studyplan_app_design.databinding.ActivityHomeScreenBinding
import com.example.a6_studyplan_app_design.databinding.ActivityMainBinding

class Home_screen : AppCompatActivity() {
    private lateinit var binding : ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signupbtn1.setOnClickListener {
            startActivity(Intent(this@Home_screen, SignUp_screen::class.java))
        }
        binding.signupbn2.setOnClickListener {
            startActivity(Intent(this@Home_screen, SignUp_screen::class.java))
        }
        binding.homebtn.setOnClickListener {
            startActivity(Intent(this@Home_screen, friend_list_screen::class.java))
        }
    }
}