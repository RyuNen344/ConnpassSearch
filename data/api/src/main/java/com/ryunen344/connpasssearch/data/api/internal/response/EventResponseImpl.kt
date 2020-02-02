package com.ryunen344.connpasssearch.data.api.internal.response

import com.ryunen344.connpasssearch.data.api.response.EventResponse
import kotlinx.serialization.Serializable

@Serializable
internal data class EventResponseImpl(
    override val resultsReturned: Int,
    override val resultsAvailable: Int,
    override val resultsStart: Int,
    override val events: List<EventItemResponseImpl>
) : EventResponse
