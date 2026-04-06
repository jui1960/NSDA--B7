package com.example.job3

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.job3.databinding.ActivityMainBinding
import com.google.android.gms.location.LocationServices
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentLat = 0.0
    private var currentLong = 0.0
    private val db = FirebaseFirestore.getInstance()

    private val fusedLocationClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetLocation.setOnClickListener {
            getLocation()
        }
        binding.btnSaveLocation.setOnClickListener {
            saveLocation()
        }
        binding.btnShowMap.setOnClickListener {
            val intent = Intent(this, Maps::class.java)
            intent.putExtra("latitude", currentLat)
            intent.putExtra("longitude", currentLong)
            startActivity(intent)

        }

    }

    private fun saveLocation() {
        val data = hashMapOf(
            "latitude" to currentLat,
            "longitude" to currentLong
        )
        db.collection("locations")
            .add(data)
            .addOnSuccessListener {
                Toast.makeText(this, "Location saved", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to save location", Toast.LENGTH_SHORT).show()
            }
    }

    fun getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)
            return
        }

        fusedLocationClient.lastLocation.addOnSuccessListener {location ->
            if(location!=null){
                currentLat = location.latitude
                currentLong = location.longitude
                Toast.makeText(this, "Lat: $currentLat, Lng: $currentLong", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show()
            }

        }
    }
}






