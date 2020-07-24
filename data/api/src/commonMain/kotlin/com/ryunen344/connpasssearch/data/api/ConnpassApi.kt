package com.ryunen344.connpasssearch.data.api

import com.ryunen344.connpasssearch.data.api.response.EventResponse

interface ConnpassApi {
    suspend fun getEvents(keyword: String? = null, count: Int, start: Int): EventResponse

    suspend fun getEvents(
        keyword: String? = null,
        count: Int,
        start: Int,
        callback: (response: EventResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    )

    suspend fun getEvent(eventId: Int): EventResponse

    suspend fun getEvent(
        eventId: Int,
        callback: (response: EventResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    )
}
