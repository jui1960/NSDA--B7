package com.example.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("appId") appKey: String,
        @Query("units") units: String
    ): Call<WeatherModel>


}