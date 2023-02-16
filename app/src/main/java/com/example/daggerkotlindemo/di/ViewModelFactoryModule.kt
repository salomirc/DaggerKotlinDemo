package com.example.daggerkotlindemo.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggerkotlindemo.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}