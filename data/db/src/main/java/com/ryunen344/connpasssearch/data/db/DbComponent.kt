package com.ryunen344.connpasssearch.data.db

import android.content.Context
import com.ryunen344.connpasssearch.data.db.interfaces.EventDatabase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
@Component(
    modules = [
        DbModule::class
    ]
)
interface DbComponent {
    fun eventDatabase(): EventDatabase

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance coroutineContext: CoroutineContext,
            @BindsInstance filename: String?
        ): DbComponent
    }

    companion object {
        fun factory(): Factory = DaggerDbComponent.factory()
    }
}
