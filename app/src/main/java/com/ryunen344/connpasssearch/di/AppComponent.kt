package com.ryunen344.connpasssearch.di

import com.ryunen344.connpasssearch.App
import com.ryunen344.connpasssearch.di.repository.RepositoryModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        RetrofitModule::class,
        RepositoryModule::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}