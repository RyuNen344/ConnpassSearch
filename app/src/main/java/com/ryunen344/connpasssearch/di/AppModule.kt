package com.ryunen344.connpasssearch.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = [AppModuleBinds::class])
class AppModule {
    @Provides
    fun provideAppContext(application: Application): Context {
        return application
    }
}
