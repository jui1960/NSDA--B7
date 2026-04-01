package com.example.retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ActivityDetailsScreenBinding
import com.example.retrofit.databinding.ActivityMainBinding

class DetailsScreen : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val title = intent.getStringExtra("title")
        val dec = intent.getStringExtra("description")
        val image = intent.getStringExtra("image")
        val category = intent.getStringExtra("category")
        val price = intent.getDoubleExtra("price", 0.0)


        binding.apply {
            detailProductTitle.text = title
            binding.detailProductPrice.text = "$$price"
            detailProductDescription.text = dec
            detailProductCategory.text = category


        }
        Glide.with(this)
            .load(image)
            .into(binding.detailProductImage)

    }
}