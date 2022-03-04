package com.fifththirdbankcc.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JokesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JokesApp)
            modules(listOf(networkModule, viewModelModule))
        }
    }
}