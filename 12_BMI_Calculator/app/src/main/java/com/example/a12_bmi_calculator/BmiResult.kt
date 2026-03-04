package com.example.a12_bmi_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a12_bmi_calculator.databinding.ActivityBmiResultBinding
import com.example.a12_bmi_calculator.databinding.ActivityMainBinding

class BmiResult : AppCompatActivity() {
    private lateinit var binding: ActivityBmiResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmi_result)
        binding = ActivityBmiResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getDoubleExtra("BMI VALUE",0.0)
        binding.bmiResult.text = String.format("%.2f", bmi)


        val status : String
        val advice : String
        val color : Int

        when {
            bmi < 18.5 -> {
                status = "Underweight"
                advice = "You need to eat more and stay healthy!"
                color = android.graphics.Color.YELLOW

            }

            bmi in 18.5..24.9 -> {
                status = "Normal / Fit"
                advice = "Great! Keep maintaining your lifestyle."
                color = android.graphics.Color.GREEN

            }

            bmi in 25.0..29.9 -> {
                status = "Overweight"
                advice = "Try to do some exercise and control diet."
                color = android.graphics.Color.BLUE
            }

            else -> {
                status = "Obese"
                advice = "Alert! Please consult a doctor and hit the gym."
                color = android.graphics.Color.RED

            }
        }
        binding.bmiStatus.text = status
        binding.bmiStatus.setTextColor(color)
        binding.bmiAdvice.text = advice

    }
}