package com.ryunen344.connpasssearch.initializer

class AppInitializers(private val initializers: List<AppInitializer>) {
    fun initialize() {
        initializers.forEach { it.initialize() }
    }
}
