package com.ryunen344.connpasssearch.data.api

import android.content.Context
import com.ryunen344.connpasssearch.data.api.internal.ApiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class
    ]
)
interface ApiComponent {

    fun ConnpassApi(): ConnpassApi

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApiComponent
    }

    companion object {
        fun factory(): Factory = DaggerApiComponent.factory()
    }
}
