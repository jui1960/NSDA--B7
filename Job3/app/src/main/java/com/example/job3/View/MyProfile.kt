package com.example.job3.View

import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.job3.databinding.ActivityMyProfileBinding
import com.google.android.gms.location.LocationServices
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MyProfile : AppCompatActivity() {

    private lateinit var binding: ActivityMyProfileBinding
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    private var currentLat = 0.0
    private var currentLng = 0.0

    private val fusedLocationClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)
    }

    private var updatedName: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val email = intent.getStringExtra("email")
        binding.tvUserEmail.text = email
        updatedName = email ?: ""

        getLocation()


        binding.btnGetLocation.setOnClickListener {
            getLocation()
        }

        binding.btnSaveLocation.setOnClickListener {
            if (currentLat != 0.0 && currentLng != 0.0) saveLocation()
            else Toast.makeText(this, "Please get location first", Toast.LENGTH_SHORT).show()
        }


        binding.btnUpdateName.setOnClickListener {
            val newName = binding.etUpdateUsername.text.toString().trim()
            if (newName.isNotEmpty()) {
                updatedName = newName
                binding.tvUserEmail.text = newName
                Toast.makeText(this, "Name updated!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnViewMap.setOnClickListener {
            if (currentLat != 0.0 && currentLng != 0.0) {
                val intent = Intent(this, MapFragment::class.java)
                intent.putExtra("latitude", currentLat)
                intent.putExtra("longitude", currentLng)
                intent.putExtra("username", updatedName)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Location data not available", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ivBack.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, Auth::class.java))
            finish()
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
        if (ActivityCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 100
            )
            return
        }

        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "Please enable location", Toast.LENGTH_SHORT).show()
            return
        }

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                currentLat = location.latitude
                currentLng = location.longitude
                Toast.makeText(this, "Location detected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Could not find location. Try again.", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveLocation() {
        val data = hashMapOf(
            "latitude" to currentLat,
            "longitude" to currentLng
        )
        db.collection("users").add(data)
            .addOnSuccessListener {
                Toast.makeText(this, "Location Saved", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to save", Toast.LENGTH_SHORT).show()
            }
    }
}