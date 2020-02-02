package com.ryunen344.connpasssearch.data.api.response

import com.soywiz.klock.DateTimeTz

interface EventItemResponse {
    val eventId: Int
    val title: String
    val catch: String
    val description: String
    val eventUrl: String
    val hashTag: String
    val startedAt: DateTimeTz
    val endedAt: DateTimeTz
    val limit: Int
    val eventType: EventTypeResponse
    val series: GroupResponse
    val address: String
    val place: String
    val lat: Float
    val lon: Float
    val ownerId: Int
    val ownerNickname: String
    val ownerDisplayName: String
    val accepted: Int
    val waiting: Int
    val updatedAt: DateTimeTz
}
