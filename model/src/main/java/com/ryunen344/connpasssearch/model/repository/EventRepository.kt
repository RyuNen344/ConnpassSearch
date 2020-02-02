package com.ryunen344.connpasssearch.model.repository

import com.ryunen344.connpasssearch.model.Event
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    suspend fun getEventList(currentPage: Int): Flow<Event>

    suspend fun getEvent(eventId: Int): Flow<Event>

    suspend fun searchEventList(keyword: String, currentPage: Int): Flow<Event>

    suspend fun refresh()
}
