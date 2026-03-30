package com.example.firestore

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.firestore.databinding.ActivityAddScreenBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddScreen : AppCompatActivity() {
    private lateinit var binding: ActivityAddScreenBinding
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()



        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val friend = hashMapOf(
                "name" to name, "email" to email
            )

            db.collection("friends").add(friend).addOnSuccessListener {
                Toast.makeText(this, "Friend Added", Toast.LENGTH_SHORT).show()
                finish()

            }.addOnFailureListener {
                Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
            }


        }
    }
}