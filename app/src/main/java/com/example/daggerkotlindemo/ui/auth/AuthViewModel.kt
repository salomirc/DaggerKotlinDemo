package com.example.daggerkotlindemo.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerkotlindemo.network.auth.AuthApi
import javax.inject.Inject


class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {
    init {
        Log.d(TAG, "AuthViewModel: ViewModel is working!")
        Log.d(TAG, "AuthViewModel: auth api is NOT NULL")
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}