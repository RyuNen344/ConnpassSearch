package com.ryunen344.connpasssearch.data.db.entity

import com.soywiz.klock.DateTimeTz

interface EventEntity {
    val eventId: Int
    val title: String
    val catch: String
    val description: String
    val eventUrl: String
    val hashTag: String
    val startedAt: DateTimeTz
    val endedAt: DateTimeTz
    val limit: Int
    val eventType: String
    val series: GroupEntity?
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
