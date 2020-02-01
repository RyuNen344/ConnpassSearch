package com.ryunen344.connpasssearch.data.api

import com.ryunen344.connpasssearch.data.api.response.EventResponse
import kotlinx.coroutines.Deferred

interface ConnpassApi {
    suspend fun getEvents(keyword: String? = null, count: Int, start: Int): EventResponse

    fun getEvents(
        keyword: String? = null,
        count: Int,
        start: Int,
        callback: (response: EventResponse) -> Unit,
        onError: (error: Exception) -> Unit
    )

    fun getEventsAsync(keyword: String? = null, count: Int, start: Int): Deferred<EventResponse>

    suspend fun getEvent(eventId: Int): EventResponse

    fun getEvent(
        eventId: Int,
        callback: (response: EventResponse) -> Unit,
        onError: (error: Exception) -> Unit
    )

    fun getEventAsync(eventId: Int): Deferred<EventResponse>
}
