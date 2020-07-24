package com.ryunen344.connpasssearch.data.db

import com.ryunen344.connpasssearch.data.api.response.EventResponse
import com.ryunen344.connpasssearch.data.db.dao.EventDao
import com.ryunen344.connpasssearch.data.db.interfaces.EventDatabase
import com.ryunen344.connpasssearch.model.Event
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class RoomDatabase @Inject constructor(
    private val cacheDatabase: CacheDatabase,
    private val eventDao: EventDao
) : EventDatabase {
    override fun events(): Flow<List<Event>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun save(apiResponse: EventResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
