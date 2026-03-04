package com.example.a13_sharepreference

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a13_sharepreference.databinding.ActivityInputScreenBinding
import com.example.a13_sharepreference.databinding.ActivityMainBinding

class InputScreen : AppCompatActivity() {
    private lateinit var binding: ActivityInputScreenBinding
    private lateinit var sharePref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityInputScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharePref = getSharedPreferences("note_sharepref", MODE_PRIVATE)
        val savenote = sharePref.getString("note","")



        binding.btnSave.setOnClickListener {

            val inputtx = binding.EdTxt.text.toString()
            sharePref.edit().putString("note",inputtx).apply()


            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("jui",inputtx)
            startActivity(intent)

        }

    }
}