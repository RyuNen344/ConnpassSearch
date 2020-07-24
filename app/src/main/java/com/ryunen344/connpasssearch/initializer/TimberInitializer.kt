package com.ryunen344.connpasssearch.initializer

import com.ryunen344.connpasssearch.BuildConfig
import timber.log.LogcatTree
import timber.log.Timber

class TimberInitializer : AppInitializer {
    override fun initialize() {
        if (BuildConfig.DEBUG) {
            Timber.plant(LogcatTree())
        }
    }
}
