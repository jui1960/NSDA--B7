package com.example.firestore.Model

import android.Manifest
import android.content.Context

import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
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
                val user = AppUser(userId, email, userName)
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
            .addOnFailureListener { e ->
                onComplete(false, e.message)
            }
    }


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


    fun UpdateLocation(userId: String, lat: Double, lng: Double, onComplete: (Boolean) -> Unit) {
        db.collection("users").document(userId).update(
            mapOf(
                "latitude" to lat,
                "longitude" to lng
            )
        ).addOnSuccessListener {
            onComplete.invoke(true)
        }.addOnFailureListener {
            onComplete.invoke(false)
        }

    }

    fun updateLocationAuto(context: Context, onComplete: (Boolean) -> Unit) {
        val fused = LocationServices.getFusedLocationProviderClient(context)
        val userId = getCurrentUserId() ?: return

        if (ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onComplete(false)
            return
        }
        fused.lastLocation.addOnSuccessListener { loc ->
            if (loc != null) {
                UpdateLocation(userId, loc.latitude, loc.longitude){ success ->
                    onComplete(success)

                }
            } else {
                onComplete(false)
            }
        }

    }
    fun logOut() {
        auth.signOut()
    }

    fun updateUserName(uid: String, newName: String, callback: (Boolean) -> Unit) {
        db.collection("users").document(uid)
            .update("userName", newName)
            .addOnSuccessListener { callback(true) }
            .addOnFailureListener { callback(false) }
    }


    fun getUserLocation(uid: String, callback: (Double?, Double?) -> Unit) {
        db.collection("users").document(uid).get()
            .addOnSuccessListener { doc ->
                val lat = doc.getDouble("latitude")
                val lng = doc.getDouble("longitude")
                callback(lat, lng)
            }
    }
}
