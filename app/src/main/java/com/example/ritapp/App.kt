package com.example.ritapp

import android.app.Application
import com.example.ritapp.di.AppComponent
import com.example.ritapp.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}