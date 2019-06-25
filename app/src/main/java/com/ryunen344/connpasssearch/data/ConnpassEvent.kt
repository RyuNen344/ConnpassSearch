package com.ryunen344.connpasssearch.data

import androidx.databinding.BaseObservable

data class ConnpassEvent(
    var results_returned: Int,
    var results_available: Int,
    var results_start: Int,
    var events: MutableList<Event>
) : BaseObservable()