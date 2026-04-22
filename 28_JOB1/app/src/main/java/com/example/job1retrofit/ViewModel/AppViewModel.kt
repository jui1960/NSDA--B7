package com.example.job1retrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.job1retrofit.Model.Product
import com.example.job1retrofit.Repository.AppRepository

class AppViewModel : ViewModel() {
    private val repository = AppRepository()
    val product: LiveData<List<Product>> = repository.getProductList()
    val error: LiveData<String> = repository.getError()

}