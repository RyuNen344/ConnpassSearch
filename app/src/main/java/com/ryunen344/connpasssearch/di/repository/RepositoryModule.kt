package com.ryunen344.connpasssearch.di.repository

import com.ryunen344.connpasssearch.data.source.EventRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideEventRepository() = EventRepository()

}