package com.ryunen344.connpasssearch.data

data class ConnpassEvent(
    var results_returned: Int,
    var results_available: Int,
    var results_start: Int,
    var events: List<Event>
)