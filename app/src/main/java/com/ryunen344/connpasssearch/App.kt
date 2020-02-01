package com.ryunen344.connpasssearch

import android.app.Application
import com.ryunen344.connpasssearch.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        //dependency inject
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)
    }
}
