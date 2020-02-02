package com.ryunen344.connpasssearch.data.api.internal.response

import com.ryunen344.connpasssearch.core.util.DateTimeTzSerializer
import com.ryunen344.connpasssearch.data.api.response.EventItemResponse
import com.soywiz.klock.DateTimeTz
import kotlinx.serialization.Serializable

@Serializable
internal data class EventItemResponseImpl(
    override val eventId: Int,
    override val title: String,
    override val catch: String,
    override val description: String,
    override val eventUrl: String,
    override val hashTag: String,

    @Serializable(with = DateTimeTzSerializer::class)
    override val startedAt: DateTimeTz,

    @Serializable(with = DateTimeTzSerializer::class)
    override val endedAt: DateTimeTz,

    override val limit: Int,
    override val eventType: EventTypeResponseImpl,
    override val series: GroupResponseImpl,
    override val address: String,
    override val place: String,
    override val lat: Float,
    override val lon: Float,
    override val ownerId: Int,
    override val ownerNickname: String,
    override val ownerDisplayName: String,
    override val accepted: Int,
    override val waiting: Int,

    @Serializable(with = DateTimeTzSerializer::class)
    override val updatedAt: DateTimeTz
) : EventItemResponse

