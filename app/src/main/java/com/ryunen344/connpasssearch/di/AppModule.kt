package com.ryunen344.connpasssearch.di

import com.ryunen344.connpasssearch.initializer.AppInitializers
import com.ryunen344.connpasssearch.initializer.CoilInitializer
import com.ryunen344.connpasssearch.initializer.TimberInitializer
import com.ryunen344.connpasssearch.initializer.UniFlowLoggerInitializer
import org.koin.dsl.module

val appModule = module {
    single { listOf(CoilInitializer(get()), TimberInitializer(), TimberInitializer(), UniFlowLoggerInitializer()) }
    single { AppInitializers(get()) }
}
