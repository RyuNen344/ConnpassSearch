package com.ryunen344.connpasssearch.di

import android.content.Context
import com.ryunen344.connpasssearch.data.api.ConnpassApi
import com.ryunen344.connpasssearch.data.repository.RepositoryComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryComponentModule {

    @Singleton
    @Provides
    fun provideEventRepository(repositoryComponent: RepositoryComponent) =
        repositoryComponent.eventRepository()

    @Provides
    @Singleton
    fun provideRepositoryComponent(
        context: Context,
        connpassApi: ConnpassApi
    ): RepositoryComponent {
        return RepositoryComponent.factory()
            .create(
                context = context,
                connpassApi = connpassApi
            )
    }
}
