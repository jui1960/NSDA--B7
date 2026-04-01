package com.example.retrofit

import android.util.Printer


data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val rating: String,
    val images: List<String>

)