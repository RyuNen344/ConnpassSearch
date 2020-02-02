package com.ryunen344.connpasssearch

import com.ryunen344.connpasssearch.core.di.AppComponentHolder
import com.ryunen344.connpasssearch.di.AppComponent
import com.ryunen344.connpasssearch.di.createAppComponent
import com.ryunen344.connpasssearch.initializer.AppInitializers
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication(), AppComponentHolder {

    override val appComponent: AppComponent by lazy {
        createAppComponent()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

    @Inject
    lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        //dependency inject
        initializers.initialize(this)
    }


}
