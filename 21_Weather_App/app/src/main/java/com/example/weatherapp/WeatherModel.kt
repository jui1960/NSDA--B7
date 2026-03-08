package com.example.weatherapp



data class WeatherModel(
    val main: Main,
    val wind: Wind,
    val weather: List<WeatherInfo>,
    val cloud : Clouds
)

data class WeatherInfo(
    val st: String,
    val description: String
)

data class Main(
    val temp: Double,
    val humidity: Int
)

data class Wind(
    val speed: Double
)
data class Clouds(
    val all : Int
)
