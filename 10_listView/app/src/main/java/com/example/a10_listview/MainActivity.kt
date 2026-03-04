package com.example.a10_listview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.a10_listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var friendlist  : ArrayList<Friend>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        val adapter = FriendAdepter(this,friendlist)
        binding.listview.adapter = adapter



    }
    private fun loadData(){
        friendlist= arrayListOf(
            Friend("jannati akter jui","he is very good girl",
                R.drawable.picc),
            Friend("Aminul Islam Munna", "he is a very good boy he is a very good boy he is a very good boy he is a very good boy he is a very good boy he is a very good boy", R.drawable.picc),
            Friend("Aminul Islam Munna", "he is a very good boy", R.drawable.picc),
            Friend("Aminul Islam Munna", "he is a very good boy", R.drawable.picc),
            Friend("Aminul Islam Munna", "he is a very good boy", R.drawable.picc),
            Friend("Aminul Islam Munna", "he is a very good boy", R.drawable.picc),
            Friend("Aminul Islam Munna", "he is a very good boy", R.drawable.picc),
            Friend("Aminul Islam Munna", "he is a very good boy", R.drawable.picc),
            Friend("Aminul Islam Munna", "he is a very good boy", R.drawable.picc),
        )
    }
}