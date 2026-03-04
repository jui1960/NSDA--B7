package com.example.a11_recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a11_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var friendAdapter: FriendAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val friendlist = listOf(
            Friend("Jui", "Very Good Student", R.drawable.picc),
            Friend("Mahmuda", "Very Good Student", R.drawable.picc),
            Friend("Nishat", "Very Good Student", R.drawable.picc),
            Friend("Rownok", "Very Good Student", R.drawable.picc),
            Friend("Jesi", "Very Good Student", R.drawable.picc),
            Friend("Jiniiya", "Very Good Student", R.drawable.picc),
            Friend("Jeri", "Very Good Student", R.drawable.picc),

            )
        friendAdapter = FriendAdapter(friendlist)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = friendAdap
        }

    }
}
