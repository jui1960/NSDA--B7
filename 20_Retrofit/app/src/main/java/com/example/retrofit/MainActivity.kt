package com.example.retrofit

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        loadData()

        binding.fab.setOnClickListener {
            loadData()
        }
    }

    private fun loadData() {

        ApiClient.api.getProducts().enqueue(object : Callback<List<Product>> {

            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {

                if (response.isSuccessful) {

                    val list = response.body() ?: emptyList()

                    binding.recyclerView.adapter = ProductAdapter(list) { product ->

                        val intent = Intent(this@MainActivity, DetailsScreen::class.java)

                        intent.putExtra("title", product.title)
                        intent.putExtra("description", product.description)
                        intent.putExtra("price", product.price) // Double
                       val imageUrl = if (product.images.isNotEmpty()) {
                            product.images[0]
                        } else ""
                        intent.putExtra("image", imageUrl)
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {

                Toast.makeText(
                    this@MainActivity,
                    "Error: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}