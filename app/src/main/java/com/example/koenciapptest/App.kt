package com.example.koenciapptest

import android.app.Application
import com.example.koenciapptest.di.myAppModule
import com.github.ajalt.timberkt.Timber
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@App)
            modules(myAppModule)
        }
    }

}