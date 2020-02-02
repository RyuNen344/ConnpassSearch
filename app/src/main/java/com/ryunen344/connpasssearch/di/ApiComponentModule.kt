package com.ryunen344.connpasssearch.di

import android.app.Application
import com.ryunen344.connpasssearch.data.api.ApiComponent
import com.ryunen344.connpasssearch.data.api.ConnpassApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ApiComponentModule {

    @Provides
    @Singleton
    fun provideConnpassApi(application: Application): ConnpassApi {
        return ApiComponent.factory()
            .create(application)
            .ConnpassApi()
    }
}
