package com.example.firestore.View

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firestore.Model.UserRepository
import com.example.firestore.R
import com.example.firestore.databinding.ActivityMapsBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapsBinding
    private lateinit var map: GoogleMap

    private val repo = UserRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment =  supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this) ?: run {
                Toast.makeText(
                    this, "Map not found",
                    Toast.LENGTH_SHORT
                ).show()
            }


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
                            .title(it.userName.ifEmpty {
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

            list.forEach { users ->
                if (users.latitude != null && users.longitude != null) {
                    val pos = LatLng(users.latitude, users.longitude)

                    map.addMarker(
                        MarkerOptions()
                            .position(pos)
                            .title(users.userName.ifEmpty {
                                users.email
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
