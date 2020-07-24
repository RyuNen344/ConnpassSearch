package com.ryunen344.connpasssearch.data.api.internal.response

import com.ryunen344.connpasssearch.data.api.internal.serializer.DateTimeTzSerializer
import com.ryunen344.connpasssearch.data.api.response.EventItemResponse
import com.soywiz.klock.DateTimeTz
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class EventItemResponseImpl(
    @SerialName("event_id") override val eventId: Int,
    @SerialName("title") override val title: String,
    @SerialName("catch") override val catch: String,
    @SerialName("description") override val description: String,
    @SerialName("event_url") override val eventUrl: String,
    @SerialName("hash_tag") override val hashTag: String,

    @Serializable(with = DateTimeTzSerializer::class)
    @SerialName("started_at")
    override val startedAt: DateTimeTz,

    @Serializable(with = DateTimeTzSerializer::class)
    @SerialName("ended_at")
    override val endedAt: DateTimeTz,

    @SerialName("limit")
    override val limit: Int,

    @SerialName("event_type")
    override val eventType: String,

    @SerialName("series")
    override val series: GroupResponseImpl?,

    @SerialName("address")
    override val address: String,

    @SerialName("place")
    override val place: String,

    @SerialName("lat")
    override val lat: Float,

    @SerialName("lon")
    override val lon: Float,

    @SerialName("owner_id")
    override val ownerId: Int,

    @SerialName("owner_nickname")
    override val ownerNickname: String,

    @SerialName("owner_display_name")
    override val ownerDisplayName: String,

    @SerialName("accepted")
    override val accepted: Int,

    @SerialName("waiting")
    override val waiting: Int,

    @Serializable(with = DateTimeTzSerializer::class)
    @SerialName("updated_at")
    override val updatedAt: DateTimeTz
) : EventItemResponse
