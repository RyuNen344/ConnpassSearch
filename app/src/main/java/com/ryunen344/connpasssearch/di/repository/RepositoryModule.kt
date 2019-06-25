package com.ryunen344.connpasssearch.di.repository

import com.ryunen344.connpasssearch.data.source.EventRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single { EventRepository(get()) }
}