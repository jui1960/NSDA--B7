package com.example.jui_9_rest01


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jui_9_rest01.databinding.ActivityProductBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        fetchProducts()

        binding.fab.setOnClickListener {

            fetchProducts()


            binding.recyclerView.smoothScrollToPosition(0)


            Toast.makeText(this, "Refreshing..", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    private fun fetchProducts() {
        ApiClient.api.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful && response.body() != null) {
                    val productList = response.body()!!

                    adapter = ProductAdapter(productList) { product ->
                        Toast.makeText(this@ProductActivity, product.title, Toast.LENGTH_SHORT)
                            .show()
                    }
                    binding.recyclerView.adapter = adapter
                } else {
                    Toast.makeText(
                        this@ProductActivity,
                        "Data Error: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(
                    this@ProductActivity,
                    "Network Error: ${t.message}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        })
    }
}