package com.example.weatherapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.weatherapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val apiKey = "dad2d7d3a32ae053317a66ad1ecafba9"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getWeatherBtn.setOnClickListener {

            val city = binding.cityInput.text.toString()

            ApiClient.api.getWeather(
                city,
                apiKey,
                "metric"
            ).enqueue(object : Callback<WeatherModel> {

                override fun onResponse(
                    call: Call<WeatherModel?>,
                    response: Response<WeatherModel?>
                ) {

                    if (response.isSuccessful) {

                        val weatherModel = response.body()

                        binding.tempText.text = "Temp : ${weatherModel?.main?.temp} C"
                        binding.humidityText.text = "${weatherModel?.main?.humidity} %"

                        binding.windText.text = "${weatherModel?.wind?.speed} km/h"

                        val cloudiness = weatherModel?.cloud?.all ?: 0
                        binding.precipitationText.text = "$cloudiness%"


                        if (weatherModel?.weather?.isNotEmpty() == true) {
                            val status = weatherModel.weather[0].description
                            binding.weatherStatus.text = status.replaceFirstChar { it.uppercase() }
                        }                    }

                }

                override fun onFailure(call: Call<WeatherModel?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}