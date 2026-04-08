package com.example.job3.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.job3.R
import com.example.job3.databinding.ActivityMapFragmentBinding
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.type.LatLng

class MapFragment : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapFragmentBinding
    private lateinit var mMap: GoogleMap
    private var lat = 0.0
    private var lng = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMapFragmentBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lat = intent.getDoubleExtra("latitude", 0.0)
        lng = intent.getDoubleExtra("longitude", 0.0)


        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val location = com.google.android.gms.maps.model.LatLng(lat, lng)

        val name = intent.getStringExtra("username"?:  "No name")

        mMap.addMarker(MarkerOptions().position(location).title(name))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        mMap.uiSettings.isZoomControlsEnabled = true

    }
}