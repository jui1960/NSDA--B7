package com.example.a6_studyplan_app_design

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a6_studyplan_app_design.databinding.ActivityHomeScreenBinding
import com.example.a6_studyplan_app_design.databinding.ActivityMainBinding
import com.example.a6_studyplan_app_design.databinding.ActivitySignUpScreenBinding

class SignUp_screen : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signupbtn.setOnClickListener {
            startActivity(Intent(this@SignUp_screen, friend_list_screen::class.java))
        }

    }
}