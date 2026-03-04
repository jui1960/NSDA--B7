package com.example.a11_recycleviewclick

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a11_recycleviewclick.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var youtubeAdapter: YoutubeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val youtubeData = listOf(
            YoutubeData(
                R.drawable.youtubeimg1,
                R.drawable.youtubeimg1,
                "Tumi Bristi Cheyecho Bole | Mahtim sakib | New Lyrical Song 2024"
            ),
            YoutubeData(
                R.drawable.youtubeimg2,
                R.drawable.youtubeimg2,
                "Ami Sei Shuto || আমি সেই সুতো || Tahsan || Uddeshsho Nei || New Bangla Song | Official Lyrical Video"
            ),
            YoutubeData(
                R.drawable.youtubeimg3,
                R.drawable.youtubeimg3,
                "Tumi Bristi Cheyecho Bole | Mahtim sakib | New Lyrical Song 2024"
            ),
            YoutubeData(
                R.drawable.youtubeimg1,
                R.drawable.youtubeimg1,
                "Tumi Bristi Cheyecho Bole | Mahtim sakib | New Lyrical Song 2024"
            ),
            YoutubeData(
                R.drawable.youtubeimg2,
                R.drawable.youtubeimg2,
                "Tumi Bristi Cheyecho Bole | Mahtim sakib | New Lyrical Song 2024"
            ),
            YoutubeData(
                R.drawable.youtubeimg3,
                R.drawable.youtubeimg3,
                "Tumi Bristi Cheyecho Bole | Mahtim sakib | New Lyrical Song 2024"
            )
        )

        youtubeAdapter = YoutubeAdapter(youtubeData)
        binding.recycleview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = youtubeAdapter
        }

    }


}