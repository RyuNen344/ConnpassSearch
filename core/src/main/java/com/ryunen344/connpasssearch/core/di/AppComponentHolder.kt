package com.ryunen344.connpasssearch.core.di

import com.ryunen344.connpasssearch.model.repository.EventRepository

interface AppComponentHolder {
    val appComponent: AppComponentInterface
}

interface AppComponentInterface {
    fun eventRepository(): EventRepository
}
