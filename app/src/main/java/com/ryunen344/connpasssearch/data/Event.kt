package com.ryunen344.connpasssearch.data

data class Event(
    var event_id: Int,
    var title: String,
    var catch: String,
    var description: String,
    var event_url: String,
    var hash_tag: String,
    var started_at: String,
    var ended_at: String,
    var limit: Int,
    var event_type: String,
    var series: Group,
    var address: String,
    var place: String,
    var lat: Float,
    var lon: Float,
    var owner_id: Int,
    var owner_nickname: String,
    var owner_display_name: String,
    var accepted: Int,
    var waiting: Int,
    var updated_at: String
)