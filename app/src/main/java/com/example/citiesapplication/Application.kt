package com.example.citiesapplication

import android.app.Application
import com.example.citiesapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            androidLogger()
            modules(appModule)
        }
    }
}