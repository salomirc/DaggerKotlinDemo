package com.example.daggerkotlindemo.ui.auth

import android.app.Application
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerkotlindemo.R
import com.example.daggerkotlindemo.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

// Required to extend from DaggerAppCompatActivity if we use @ContributesAndroidInjector annotation
class AuthActivity : DaggerAppCompatActivity() {

    lateinit var viewModel: AuthViewModel

    @set:Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    @set:Inject
    var logo: Drawable? = null

    @set:Inject
    lateinit var requestManager: RequestManager

    @set:Inject
    lateinit var applicationInjected: Application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProvider(this, viewModelProviderFactory)[AuthViewModel::class.java]

        setLogo()
    }

    private fun setLogo() {
        requestManager
            .load(logo)
            .into((findViewById<View>(R.id.login_logo) as ImageView))
    }
}