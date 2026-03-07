package com.example.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(@Suppress("UNUSED_PARAMETER") savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.setHasFixedSize(true)
        loadProducts()
        binding.fab.setOnClickListener {
            loadProducts()
        }

    }

    private fun loadProducts() {

        ApiClient.api.getProducts().enqueue(object : Callback<List<com.example.retrofit.Product>> {

            override fun onResponse(
                call: Call<List<com.example.retrofit.Product>>,
                response: Response<List<com.example.retrofit.Product>>
            ) {

                if (response.isSuccessful) {

                    val list = response.body() ?: emptyList()

                    binding.recyclerView.adapter = ProductAdapter(list)

                }

            }

            override fun onFailure(call: Call<List<com.example.retrofit.Product>>, t: Throwable) {

                Toast.makeText(
                    this@MainActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()

            }

        })

    }
}