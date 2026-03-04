package com.example.a13_sharepreference

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a13_sharepreference.databinding.ActivityInputScreenBinding
import com.example.a13_sharepreference.databinding.ActivityMainBinding
import com.example.a13_sharepreference.databinding.ActivitySplashScreenBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedNote = intent.getStringExtra("jui")
        binding.txtnote.text = receivedNote

        val sharedPref = getSharedPreferences("note_sharepref", MODE_PRIVATE)
        binding.txtnote.text = sharedPref.getString("note", "No note saved yet!")


        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, InputScreen::class.java)
            startActivity(intent)
        }
    }


}
