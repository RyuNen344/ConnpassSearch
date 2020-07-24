package com.ryunen344.connpasssearch.data.api.response

interface EventResponse {
    val resultsReturned: Int
    val resultsAvailable: Int
    val resultsStart: Int
    val events: List<EventItemResponse>
}
