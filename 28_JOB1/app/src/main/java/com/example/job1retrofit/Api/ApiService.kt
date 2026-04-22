package com.example.job1retrofit.Api

import com.example.job1retrofit.Model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    fun getProducts(): Call<List<Product>>
}