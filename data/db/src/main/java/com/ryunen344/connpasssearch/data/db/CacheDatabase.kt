package com.ryunen344.connpasssearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ryunen344.connpasssearch.data.db.dao.EventDao
import com.ryunen344.connpasssearch.data.db.entity.EventEntityImpl
import com.ryunen344.connpasssearch.data.db.entity.mapper.DateTimeTzConverter

@Database(
    entities = [
        (EventEntityImpl::class)
    ],
    version = 0,
    exportSchema = false
)
@TypeConverters(
    value = [
        DateTimeTzConverter::class
    ]
)
internal abstract class CacheDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao

    fun sqlite(): SupportSQLiteDatabase {
        return mDatabase
    }
}
