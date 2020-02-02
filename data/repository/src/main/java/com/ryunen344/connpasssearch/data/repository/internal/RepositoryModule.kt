package com.ryunen344.connpasssearch.data.repository.internal

import com.ryunen344.connpasssearch.model.repository.EventRepository
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule.Providers::class])
internal abstract class RepositoryModule {
    @Binds
    abstract fun eventRepository(impl: DataEventRepository): EventRepository

    @Module
    internal object Providers
}
