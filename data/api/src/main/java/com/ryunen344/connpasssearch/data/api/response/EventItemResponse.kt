package com.ryunen344.connpasssearch.data.api.response

import com.soywiz.klock.DateTimeTz

interface EventItemResponse {
    val eventId: Int
    val title: String
    var catch: String
    var description: String
    var eventUrl: String
    var hashTag: String
    var startedAt: DateTimeTz
    var endedAt: DateTimeTz
    var limit: Int
    var eventType: EventTypeResponse
    var series: GroupResponse
    var address: String
    var place: String
    var lat: Float
    var lon: Float
    var ownerId: Int
    var ownerNickname: String
    var ownerDisplayName: String
    var accepted: Int
    var waiting: Int
    var updatedAt: DateTimeTz
}
