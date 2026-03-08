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
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
                        binding.humidityText.text = "Humidity : ${weatherModel?.main?.humidity} %"
                    }

                }

                override fun onFailure(call: Call<WeatherModel?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}