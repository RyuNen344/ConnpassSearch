package com.ryunen344.connpasssearch.data.http.response

import androidx.databinding.BaseObservable
import com.ryunen344.connpasssearch.data.Event

data class EventResponse(
    var results_returned: Int,
    var results_available: Int,
    var results_start: Int,
    var events: MutableList<Event>
) : BaseObservable()