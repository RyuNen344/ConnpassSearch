package com.ryunen344.connpasssearch.service

import com.ryunen344.connpasssearch.data.ConnpassEvent
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ConnpassService {

    @GET("event/")
    fun eventList(): Deferred<ConnpassEvent>
}