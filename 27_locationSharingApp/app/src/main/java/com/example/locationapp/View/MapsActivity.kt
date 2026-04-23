package com.example.locationapp.View

import android.os.Bundle
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.locationapp.R
import com.example.locationapp.Repository.UserRepository
import com.example.locationapp.ViewModel.FriendViewModel
import com.example.locationapp.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapsBinding
    private val repo = UserRepository()

    private lateinit var map: GoogleMap

    private val viewModel by viewModels<FriendViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return FriendViewModel(repo) as T
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment?.getMapAsync(this) ?: run {
            Toast.makeText(
                this, "map not found",
                Toast.LENGTH_SHORT
            ).show()


        }
        setupObserves()

    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val showAll = intent.getBooleanExtra("showAll", false)
        val userId = intent.getStringExtra("uid")
        if (showAll) {
            loadAllUsers()
        } else if (userId != null) {
            loadSingleUser(userId)
        }

    }

    private fun setupObserves() {
        viewModel.userLocation.observe(this) {
            val pos = LatLng(it.first, it.second)
            map.clear()
            map.addMarker(
                MarkerOptions()
                    .position(pos)
                    .title("Location found")
            )
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 15f))
        }
    }

    private fun loadSingleUser(userId: String) {

        repo.getUserById(userId) { user ->
            user?.let {
                val lat = it.latitude
                val lng = it.longitude
                if (lat != null && lng != null) {
                    val pos = com.google.android.gms.maps.model.LatLng(lat, lng)
                    map.clear()
                    map.addMarker(
                        com.google.android.gms.maps.model.MarkerOptions()
                            .position(pos)
                            .title(it.username.ifEmpty {
                                it.email
                            })

                    )
                    map.moveCamera(
                        com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(pos, 15f)
                    )

                }
            }
        }
    }

    private fun loadAllUsers() {

        repo.getAllUser { list ->
            map.clear()

            list.forEach { user ->
                if (user.latitude != null && user.longitude != null) {
                    val pos = LatLng(user.latitude, user.longitude)
                    map.addMarker(
                        MarkerOptions()
                            .position(pos)
                            .title(user.username.ifEmpty {
                                user.email
                            })
                    )
                }
            }
            map.moveCamera(
                com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(
                    LatLng(
                        23.7548,
                        90.3765
                    ), 15f
                )
            )


        }
    }

}