package com.example.a11_recycleviewclick

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a11_recycleviewclick.databinding.ActivityDetailsItemBinding
import com.example.a11_recycleviewclick.databinding.ActivityMainBinding

class Details_item : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val image = intent.getIntExtra("image", 0)
        val logoImage = intent.getIntExtra("logo", 0)
        val des = intent.getStringExtra("descreption")


        binding.image1details.setImageResource(image)
        binding.detailslogoimg1.setImageResource(logoImage)
        binding.titleDetails.text = des


        binding.like.setOnClickListener {
            android.widget.Toast.makeText(this, "Liked!", android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}