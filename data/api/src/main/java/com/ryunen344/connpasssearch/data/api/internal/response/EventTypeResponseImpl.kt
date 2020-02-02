package com.ryunen344.connpasssearch.data.api.internal.response

import com.ryunen344.connpasssearch.data.api.response.EventTypeResponse
import kotlinx.serialization.Serializable

@Serializable
internal data class EventTypeResponseImpl(
    override val participation: String?,
    override val advertisement: String?
) : EventTypeResponse
