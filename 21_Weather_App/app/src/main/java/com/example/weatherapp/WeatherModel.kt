package com.example.weatherapp

data class WeatherModel(
    val main: Main
)

data class Main(
    val temp: Double,
    val humidity: Int
)
