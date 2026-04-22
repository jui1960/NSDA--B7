package com.example.job1retrofit.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.job1retrofit.Api.ApiClient
import com.example.job1retrofit.Model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository {
    private val productList = MutableLiveData<List<Product>>()
    private val error = MutableLiveData<String>()
    fun getError(): LiveData<String> = error


    fun getProductList(): LiveData<List<Product>> {
        ApiClient.api.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>?>,
                response: Response<List<Product>?>
            ) {
                if (response.isSuccessful) {
                    productList.postValue(response.body())
                }
            }

            override fun onFailure(
                call: Call<List<Product>?>,
                t: Throwable
            ) {
                error.postValue(t.message)

            }

        })
        return productList

    }

}