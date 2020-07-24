package com.ryunen344.connpasssearch.data.db.interfaces

import com.ryunen344.connpasssearch.data.api.response.EventResponse
import com.ryunen344.connpasssearch.model.Event
import kotlinx.coroutines.flow.Flow

interface EventDatabase {
    fun events(): Flow<List<Event>>
    suspend fun save(apiResponse: EventResponse)
}
