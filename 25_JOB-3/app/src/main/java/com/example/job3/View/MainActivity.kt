package com.example.job3

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.job3.databinding.ActivityMainBinding
import com.google.android.gms.location.LocationServices
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentLat = 0.0
    private var currentLong = 0.0
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()


    private val fusedLocationClient by lazy {

        //phone er GPS use kore location find kore
        LocationServices.getFusedLocationProviderClient(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getLocation()

        binding.btnGetLocation.setOnClickListener {
            getLocation()
        }

        binding.btnSaveLocation.setOnClickListener {
            if (currentLat != 0.0 && currentLong != 0.0) {
                saveLocation()
            } else {
                Toast.makeText(this, "Please get location first", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, SignInScreen::class.java))
            finish()
        }

        binding.btnShowMap.setOnClickListener {
            if (currentLat != 0.0 && currentLong != 0.0) {
                val intent = Intent(this, Maps::class.java)
                intent.putExtra("latitude", currentLat)
                intent.putExtra("longitude", currentLong)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Location data not available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getLocation()
        } else {
            Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show()
        }
    }



    private fun getLocation() {
        //user location er permission dice ki na check
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100
            )
            return
        }
        val locationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager //location service ke amader code er sathe connect

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "Please enable GPS/Location", Toast.LENGTH_LONG).show()
            return
        }

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                currentLat = location.latitude
                currentLong = location.longitude
                Toast.makeText(this, "Location detected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Could not find location. Try again.", Toast.LENGTH_SHORT)
                    .show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveLocation() {
        val data = hashMapOf(
            "latitude" to currentLat, "longitude" to currentLong
        )
        db.collection("locations").add(data).addOnSuccessListener {
            Toast.makeText(this, "Saved to Firestore", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {
            Toast.makeText(this, "Failed to save", Toast.LENGTH_SHORT).show()
        }

    }


}