package com.ryunen344.connpasssearch.initializer

import android.app.Application
import timber.log.LogcatTree
import timber.log.Timber
import javax.inject.Inject

class TimberInitializer @Inject constructor() : AppInitializer {
    override fun initialize(application: Application) {
        Timber.plant(LogcatTree())
    }
}
