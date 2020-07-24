package com.ryunen344.connpasssearch.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.connpasssearch.data.db.entity.EventEntity

@Dao
internal abstract class EventDao {

    @Transaction
    @Query("SELECT * FROM event")
    abstract fun eventsLiveData(): LiveData<List<EventEntity>>

    @Transaction
    @Query("SELECT * FROM event")
    abstract fun events(): List<EventEntity>

    @Transaction
    @Query("DELETE FROM event")
    abstract fun deleteAll()

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(events: List<EventEntity>)
}
