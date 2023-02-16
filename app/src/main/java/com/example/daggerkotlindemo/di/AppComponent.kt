package com.example.daggerkotlindemo.di

import android.app.Application
import com.example.daggerkotlindemo.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


// We are telling Dagger that the AppComponent owns the @Singleton scope
@Singleton
@Component(
    modules = [
        // mandatory module if we are using the convenience classes
        // AndroidInjector and DaggerApplication from Dagger 2
        AndroidSupportInjectionModule::class,

        // our custom modules start here
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        // optional, if you want to inject the Application instance
        // in to the AppComponent implementation -> DaggerAppComponent class
        // and can be used by the submodules for DI
        @BindsInstance
        fun application(application: Application): Builder

        //mandatory
        fun build(): AppComponent
    }
}