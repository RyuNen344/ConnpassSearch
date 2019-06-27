package com.ryunen344.connpasssearch.service

import com.ryunen344.connpasssearch.data.ConnpassEvent
import retrofit2.Response
import retrofit2.http.GET

interface ConnpassService {

    @GET("event/")
    suspend fun eventList(): Response<ConnpassEvent>
}