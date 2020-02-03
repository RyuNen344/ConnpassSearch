package com.ryunen344.connpasssearch.di

import android.app.Application
import com.ryunen344.connpasssearch.App
import com.ryunen344.connpasssearch.core.di.AppComponentInterface
import com.ryunen344.connpasssearch.model.repository.EventRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class,
        RepositoryComponentModule::class,
        ApiComponentModule::class
    ]
)
interface AppComponent : AndroidInjector<App>, AppComponentInterface {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    override fun inject(app: App)

    override fun eventRepository(): EventRepository
}

fun Application.createAppComponent() = DaggerAppComponent.factory().create(this)
