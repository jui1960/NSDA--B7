package com.example.firestore.Model

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository {
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()


    fun registerUser(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {

        auth.createUserWithEmailAndPassword(email, password)

            .addOnSuccessListener { task ->
                val userId = task.user?.uid ?: return@addOnSuccessListener
                val userName = email.substringBefore("@")
                val user = AppUser(userId, userName, email)
                db.collection("users").document(userId).set(user)
                    .addOnSuccessListener {
                        onComplete(true, null)
                    }
                    .addOnFailureListener { e ->
                        onComplete(false, e.message)
                    }


            }
            .addOnFailureListener { e ->
                onComplete(false, e.message)
            }
    }

    fun loginUser(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { task ->
                onComplete(true, null)

            }
            .addOnFailureListener { e ->
                onComplete(false, e.message)
            }
    }

    fun currentUserId(): String? = auth.currentUser?.uid

}
