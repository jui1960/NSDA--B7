package com.example.locationapp.Repository

import com.example.locationapp.Model.AppUser
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

                val user = AppUser(
                    userid = userId,
                    username = userName,
                    email = email,

                    )
                db.collection("users")
                    .document(userId).set(user)
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
            .addOnFailureListener {
                onComplete(false, it.message)
            }


    }


    // recycler view te jara account khulbe tader list dekhanor jnne
    fun getAllUser(onComplete: (List<AppUser>) -> Unit) {
        db.collection("users").get()
            .addOnSuccessListener { snapshots ->
                val list = snapshots.documents.mapNotNull { doc ->
                    doc.toObject(AppUser::class.java)

                }
                onComplete(list)
            }
            .addOnFailureListener {
                onComplete(emptyList())
            }
    }

    fun getCurrentUserId(): String? = auth.currentUser?.uid
    fun getCurrentUserEmail(): String? = auth.currentUser?.email

    //friendlist ar top a nijer profile dekhanor jnne
    fun getUserById(userId: String, callback: (AppUser?) -> Unit) {
        db.collection("users").document(userId).get()
            .addOnSuccessListener {
                val user = it.toObject(AppUser::class.java)
                callback(user)
            }
            .addOnFailureListener {
                callback(null)
            }
    }


    fun updateUserName(uid: String, newName: String, callback: (Boolean) -> Unit) {
        db.collection("users").document(uid)
            .update("username", newName)
            .addOnSuccessListener { callback(true) }
            .addOnFailureListener { callback(false) }
    }

}