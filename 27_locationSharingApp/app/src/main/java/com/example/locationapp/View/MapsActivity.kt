package com.example.locationapp.View



import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.locationapp.R

import com.example.locationapp.Repository.UserRepository
import com.example.locationapp.ViewModel.MapsViewModel
import com.example.locationapp.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.getValue

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapsBinding
    private val repo = UserRepository()
    private lateinit var map: GoogleMap

    private val viewModel by viewModels<MapsViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MapsViewModel(repo) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        setupObservers()

        val showAll = intent.getBooleanExtra("showAll", false)
        val userId = intent.getStringExtra("uid")

        if (showAll) {
            viewModel.fetchAllUsers()
        } else if (userId != null) {
            viewModel.fetchUserLocation(userId)
        }
    }

    private fun setupObservers() {
        val currentUserId = repo.getCurrentUserId() // আপনার নিজের ID টা নিচ্ছি

        viewModel.userList.observe(this) { list ->
            map.clear()
            list.forEach { user ->
                if (user.latitude != null && user.longitude != null) {
                    val pos = LatLng(user.latitude!!, user.longitude!!)

                    // নিজের মার্কার লাল, বন্ধুদের নীল করার লজিক
                    val markerColor = if (user.userid == currentUserId) {
                        com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED
                    } else {
                        com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_BLUE
                    }

                    map.addMarker(
                        MarkerOptions()
                            .position(pos)
                            .title(user.username.ifEmpty { user.email })
                            .icon(com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(markerColor))
                    )
                }
            }
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(23.7548, 90.3765), 10f))
        }

        viewModel.singleUserLocation.observe(this) { user ->
            user?.let {
                if (it.latitude != null && it.longitude != null) {
                    val pos = LatLng(it.latitude!!, it.longitude!!)
                    map.clear()

                    // সিঙ্গেল ইউজার দেখার সময়ও একই লজিক কাজ করবে
                    val markerColor = if (it.userid == currentUserId) {
                        com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED
                    } else {
                        com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_BLUE
                    }

                    map.addMarker(
                        MarkerOptions()
                            .position(pos)
                            .title(it.username.ifEmpty { it.email })
                            .icon(com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(markerColor))
                    )
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 15f))
                }
            }
        }
    }}