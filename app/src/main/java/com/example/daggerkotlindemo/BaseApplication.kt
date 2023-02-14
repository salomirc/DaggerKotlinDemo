package com.example.daggerkotlindemo

import com.example.daggerkotlindemo.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        // DaggerAppComponent is a Dagger generated implementation of the declared interface AppComponent
        // and is available for intellisense after making a build (aka Make Project Ctr + F9)
        return DaggerAppComponent.builder().application(this).build()
    }
}