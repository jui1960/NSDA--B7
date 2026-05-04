package com.example.jui_9_rest01

data class Product(
    val id: Int,
    val title: String,
    val price: Double, // এপিআই-তে এটি সংখ্যা হিসেবে থাকে
    val description: String,
    val images: List<String>, // এটা অবশ্যই List হতে হবে
    val category: Category
)

data class Category(
    val id: Int,
    val name: String,
    val image: String
)