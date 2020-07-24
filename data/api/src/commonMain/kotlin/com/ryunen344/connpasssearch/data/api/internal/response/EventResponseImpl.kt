package com.ryunen344.connpasssearch.data.api.internal.response

import com.ryunen344.connpasssearch.data.api.response.EventResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class EventResponseImpl(
    @SerialName("results_returned")
    override val resultsReturned: Int,

    @SerialName("results_available")
    override val resultsAvailable: Int,

    @SerialName("results_start")
    override val resultsStart: Int,

    @SerialName("events")
    override val events: List<EventItemResponseImpl>
) : EventResponse
