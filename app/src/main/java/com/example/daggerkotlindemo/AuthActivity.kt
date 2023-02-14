package com.example.daggerkotlindemo

import android.app.Application
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

// Required to extend from DaggerAppCompatActivity if we use @ContributesAndroidInjector annotation
class AuthActivity : DaggerAppCompatActivity() {

    @set:Inject
    var logo: Drawable? = null

    @set:Inject
    lateinit var requestManager: RequestManager

    @set:Inject
    lateinit var applicationInjected: Application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        setLogo()
        println("$applicationInjected is injected with Dagger")
    }

    private fun setLogo() {
        requestManager
            .load(logo)
            .into((findViewById<View>(R.id.login_logo) as ImageView))
    }
}