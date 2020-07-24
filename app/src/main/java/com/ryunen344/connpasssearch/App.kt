package com.ryunen344.connpasssearch

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import com.ryunen344.connpasssearch.di.appModule
import com.ryunen344.connpasssearch.initializer.AppInitializers
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    private val initializers: AppInitializers by inject()

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.ERROR)
            androidContext(this@App)
            androidFileProperties()
            modules(listOf(appModule))
        }

        initializers.initialize()
    }
}
