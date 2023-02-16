package com.example.daggerkotlindemo.di.auth

import androidx.lifecycle.ViewModel
import com.example.daggerkotlindemo.di.ViewModelKey
import com.example.daggerkotlindemo.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    // How to map another ViewModel type i.e. AnotherViewModel.java
//    @Binds
//    @IntoMap
//    @ViewModelKey(AnotherViewModel::class)
//    abstract fun bindAuthViewModel(viewModel: AnotherViewModel): ViewModel
}