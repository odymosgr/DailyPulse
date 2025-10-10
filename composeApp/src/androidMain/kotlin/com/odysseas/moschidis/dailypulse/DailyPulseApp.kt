package com.odysseas.moschidis.dailypulse

import android.app.Application
import com.odysseas.moschidis.dailypulse.di.sharedKoinModules
import com.odysseas.moschidis.dailypulse.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}