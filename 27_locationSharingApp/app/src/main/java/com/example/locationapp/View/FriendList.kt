package com.example.locationapp.View

import android.os.Bundle
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
        binding.userRecycler.adapter = adapter
        viewModel.userList.observe(this) { list ->
            adapter.submitList(list)
        }
        viewModel.fetchUser()






    }
}