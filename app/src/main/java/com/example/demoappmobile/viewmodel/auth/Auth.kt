package com.example.demoappmobile.viewmodel.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Auth : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    var user by mutableStateOf<FirebaseUser?>(null)
    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    init {
        user = auth.currentUser
    }

    fun reg(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    
                } else{

                }
            }
    }

    fun signIn(email: String, password: String) {
        isLoading = true
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                isLoading = false
                if (task.isSuccessful) {
                    user = auth.currentUser

                } else {
                    error = task.exception?.localizedMessage ?: "Authentication failed"
                }
            }
    }

    fun signOut() {
        auth.signOut()
        user = null
    }


}