package com.ryunen344.connpasssearch.data.api

import com.ryunen344.connpasssearch.data.api.di.apiModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            apiModule
        )
    }

    val doOnStartup = koinApplication.koin.get<() -> Unit>()
    doOnStartup.invoke()

    return koinApplication
}
