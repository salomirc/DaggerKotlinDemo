package com.example.daggerkotlindemo.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerkotlindemo.R
import com.example.daggerkotlindemo.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


// This module is for application level dependencies of the project
// i.e. Retrofit, Glide instance etc, anything that need to exist and do not change
// during the entire lifetime of the application
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // @Singleton annotation identifies a type that the injector only instantiates once, also the scope
    // of this type will be the same as AppComponent scope (entire lifetime of the application)
    // @Provides annotation is recommended to be used with a static method to make DI more efficient
    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.white_background)
            .error(R.drawable.white_background)
    }

    // Application instance is available because it was bind to the AppComponents
    // RequestOptions is available because RequestOptions exist as a dependency inside this module
    @Singleton
    @Provides
    fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide
            .with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    fun provideDrawable(application: Application): Drawable? {
        return ContextCompat.getDrawable(application, R.drawable.logo)
    }
}