package com.ryunen344.connpasssearch.data.db

import android.content.Context
import androidx.room.Room
import com.ryunen344.connpasssearch.data.db.dao.EventDao
import com.ryunen344.connpasssearch.data.db.interfaces.EventDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DbModule.Providers::class])
internal abstract class DbModule {

    @Binds
    abstract fun eventDatabase(impl: RoomDatabase): EventDatabase

    @Module
    internal object Providers {
        @Singleton
        @Provides
        fun cacheDatabase(
            context: Context,
            filename: String?
        ): CacheDatabase {
            return Room.databaseBuilder(
                context,
                CacheDatabase::class.java,
                filename ?: "connpass.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Singleton
        @Provides
        fun eventDao(cacheDatabase: CacheDatabase): EventDao {
            return cacheDatabase.eventDao()
        }
    }
}
