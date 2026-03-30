package com.example.firestore

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firestore.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: FirebaseFirestore
    private val friendlist = ArrayList<Friend>()
    private lateinit var adapter: FriendAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        db = FirebaseFirestore.getInstance()


        adapter = FriendAdapter(friendlist) { friend ->
            deleteFriend(friend.id)
        }

        binding.btnAddFriend.setOnClickListener {
            startActivity(Intent(this, AddScreen::class.java))
        }

        binding.recyclerViewFriends.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewFriends.adapter = adapter

        loadFriend()
    }

    private fun loadFriend() {
        db.collection("friends").addSnapshotListener { value, error ->
            if (error != null) return@addSnapshotListener
            friendlist.clear()

            for (doc in value!!) {
                val friend = doc.toObject(Friend::class.java)
                friend.id = doc.id
                friendlist.add(friend)
            }
            adapter.notifyDataSetChanged()

        }
    }


    private fun deleteFriend(id: String) {

        db.collection("friends")
            .document(id)
            .delete()
    }

}
