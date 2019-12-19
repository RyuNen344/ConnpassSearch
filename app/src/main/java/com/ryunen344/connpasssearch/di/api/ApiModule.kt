package com.ryunen344.connpasssearch.di.api

import com.ryunen344.connpasssearch.service.ConnpassService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideConnpassService(retrofit: Retrofit) : ConnpassService = retrofit.create(ConnpassService::class.java)

}