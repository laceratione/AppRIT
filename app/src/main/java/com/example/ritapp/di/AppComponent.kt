package com.example.ritapp.di

import com.example.ritapp.MainViewModel
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
    fun inject(mainViewModel: MainViewModel)
}