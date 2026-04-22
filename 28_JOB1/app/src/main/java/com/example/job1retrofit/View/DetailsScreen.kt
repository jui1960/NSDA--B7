package com.example.job1retrofit.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.job1retrofit.databinding.ActivityDetailsScreenBinding

class DetailsScreen : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val des = intent.getStringExtra("description")
        val price = intent.getDoubleExtra("price", 0.0)
        val image = intent.getStringExtra("image")


        binding.apply {
            detailProductTitle.text = title
            detailProductDescription.text = des
            detailProductPrice.text = price.toString()
            back.setOnClickListener {
                finish()
            }

            Glide.with(this@DetailsScreen)
                .load(image)
                .into(detailProductImage)

        }

    }
}