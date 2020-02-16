package com.ryunen344.connpasssearch.data.api.internal.response

import com.ryunen344.connpasssearch.data.api.response.EventTypeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class EventTypeResponseImpl(
    @SerialName("participation")
    override val participation: String?,

    @SerialName("advertisement")
    override val advertisement: String?
) : EventTypeResponse
