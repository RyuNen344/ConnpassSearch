package com.ryunen344.connpasssearch.di.repository

import com.ryunen344.connpasssearch.repository.EventRepository
import com.ryunen344.connpasssearch.service.ConnpassService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideEventRepository(connpassService: ConnpassService) = EventRepository(connpassService)
}