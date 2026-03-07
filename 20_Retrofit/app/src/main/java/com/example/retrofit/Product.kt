package com.example.retrofit

data class Rating(
    val rate: Double,
    val count: Int

)

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String,
    val rating: Rating
)