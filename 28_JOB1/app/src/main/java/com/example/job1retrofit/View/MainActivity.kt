package com.example.job1retrofit.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.job1retrofit.Adapter.ProductAdapter
import com.example.job1retrofit.ViewModel.AppViewModel
import com.example.job1retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(@Suppress("UNUSED_PARAMETER") savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)


        loadProducts()
        binding.fab.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun loadProducts() {
        viewModel.product.observe(this) { list ->
            binding.recyclerView.adapter = ProductAdapter(list) { product ->
                val intent = Intent(this, DetailsScreen::class.java)
                intent.putExtra("title", product.title)
                intent.putExtra("description", product.description)
                intent.putExtra("price", product.price)
                intent.putExtra("image", product.image)
                startActivity(intent)
            }
        }
        viewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

    }
}