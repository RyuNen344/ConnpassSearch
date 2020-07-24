package com.ryunen344.connpasssearch.initializer

import android.app.Application
import com.ryunen344.connpasssearch.core.image.CoilInitializer

class CoilInitializer(private val application: Application) : AppInitializer {
    override fun initialize() {
        CoilInitializer.init(application)
    }
}
