package com.ryunen344.connpasssearch.di

import com.ryunen344.connpasssearch.App
import com.ryunen344.connpasssearch.di.api.ApiModule
import com.ryunen344.connpasssearch.di.repository.RepositoryModule
import com.ryunen344.connpasssearch.di.ui.ActivityModule
import com.ryunen344.connpasssearch.di.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApiModule::class,
        RepositoryModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}