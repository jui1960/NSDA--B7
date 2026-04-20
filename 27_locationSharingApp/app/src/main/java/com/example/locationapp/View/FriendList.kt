package com.example.locationapp.View

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.locationapp.Adapter.FriendAdapter
import com.example.locationapp.Repository.UserRepository
import com.example.locationapp.ViewModel.FriendViewModel
import com.example.locationapp.databinding.ActivityFriendListBinding

class FriendList : AppCompatActivity() {
    private lateinit var binding: ActivityFriendListBinding
    private val repo = UserRepository()

    private var isMenuOpen = false

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

        binding = ActivityFriendListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val density = resources.displayMetrics.density
            val padding16dp = (16 * density).toInt()

            v.setPadding(
                padding16dp,
                systemBars.top + padding16dp,
                padding16dp,
                systemBars.bottom + padding16dp
            )
            insets
        }
        val adapter = FriendAdapter { selectedUser ->
            Toast.makeText(this, "Clicked : ${selectedUser.username}", Toast.LENGTH_SHORT).show()

        }
        binding.userRecycler.layoutManager = LinearLayoutManager(this)
        binding.userRecycler.setHasFixedSize(true)
        binding.userRecycler.adapter = adapter
        viewModel.fetchUser()

        viewModel.userList.observe(this) { list ->
            val currentUid = repo.getCurrentUserId()

            adapter.submitList(list.filter { it.userid != currentUid })
        }

        loadCurrentUser()



        binding.layoutMyProfile.setOnClickListener {
            val uid = repo.getCurrentUserId() ?: return@setOnClickListener
            startActivity(Intent(this, MyProfileActivity::class.java).apply {
                putExtra("uid", uid)
            })
        }
        binding.fabMain.setOnClickListener {
            if (isMenuOpen) closeMenu() else openMenu()

        }
        binding.fabProfile.setOnClickListener {
            val uid = repo.getCurrentUserId() ?: return@setOnClickListener
            val email = repo.getCurrentUserEmail() ?: ""


            startActivity(Intent(this, MapsActivity::class.java).apply {
                putExtra("uid", uid)
                putExtra("email", email)
            })
            closeMenu()
        }
        binding.fabShowMap.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java).apply {
                putExtra("showAll", true)
            })
            closeMenu()

        }


    }

    private fun openMenu() {
        binding.fabProfile.visibility = View.VISIBLE
        binding.fabShowMap.visibility = View.VISIBLE
        binding.fabLogout.visibility = View.VISIBLE
        isMenuOpen = true


    }

    private fun closeMenu() {
        binding.fabProfile.visibility = View.GONE
        binding.fabLogout.visibility = View.GONE
        binding.fabShowMap.visibility = View.GONE
        isMenuOpen = false

    }


    override fun onResume() {
        super.onResume()
        isMenuOpen = false
        closeMenu()
        loadCurrentUser()
    }

    @SuppressLint("SetTextI18n")
    fun loadCurrentUser() {
        val uid = repo.getCurrentUserId() ?: return
        repo.getUserById(uid) { user ->
            user?.let {
                binding.tvMyProfileName.text = it.username
                binding.tvMyProfileEmail.text = it.email
                binding.tvMyProfileLat.text = "Lat: ${it.latitude ?: 0.0}"
                binding.tvMyProfileLng.text = "Lng: ${it.longitude ?: 0.0}"
            } ?: run {
                binding.tvMyProfileName.text = "User not found"
            }
        }


    }
}
