package com.ryunen344.connpasssearch.initializer

import android.app.Application
import com.ryunen344.connpasssearch.core.image.CoilInitializer
import javax.inject.Inject

class CoilInitializer @Inject constructor() : AppInitializer {
    override fun initialize(application: Application) {
        CoilInitializer.init(application)
    }
}
