package com.ryunen344.connpasssearch.di.api

import org.koin.dsl.module

val ApiModule = module {
    single { ApiProvider() }
}