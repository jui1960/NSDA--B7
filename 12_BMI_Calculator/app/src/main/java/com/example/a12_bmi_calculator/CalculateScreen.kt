package com.example.a12_bmi_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a12_bmi_calculator.databinding.ActivityCalculateScreenBinding

class CalculateScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCalculateScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalculateScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val username = intent.getStringExtra("USER_NAME")
        binding.welcNICal.text = "Hello, $username"

        binding.bmibutton.setOnClickListener {

            val weightv = binding.weightEt.text.toString().trim()
            val heightv = binding.heightEt.text.toString().trim()

            if (weightv.isEmpty()) {
                binding.weightlayout.error = "Enter Weight"
            } else {
                binding.weightlayout.error = null
            }

            if (heightv.isEmpty()) {
                binding.heightlayout.error = "Enter height"
            } else {
                binding.heightlayout.error = null
            }

            val weight = weightv.toDouble()
            val height = heightv.toDouble()

            val convert = height.toInt()
            val inc = ((height-convert)*10).toInt()
            val totalInc = (convert*12)+inc

            val heightt = totalInc*0.0254

            val bmi = weight / (heightt * heightt)


            val intent = Intent(this, BmiResult::class.java)

            intent.putExtra("BMI VALUE", bmi)
            startActivity(intent)
        }

    }
}