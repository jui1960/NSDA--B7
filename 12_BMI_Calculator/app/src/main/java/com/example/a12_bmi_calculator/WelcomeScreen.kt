package com.example.a12_bmi_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a12_bmi_calculator.databinding.ActivityWelcomeScreenBinding

class WelcomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.NextBtn.setOnClickListener {
            val name = binding.EdTxt.text.toString().trim()
            if (name.isEmpty()) {
                binding.textInputLayout.error = "Please Enter Your Name"
            } else {
                binding.textInputLayout.error = null
                val intent = Intent(this, CalculateScreen::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            }
        }

    }
}