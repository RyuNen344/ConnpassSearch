package com.ryunen344.connpasssearch.service

import com.ryunen344.connpasssearch.data.ConnpassEvent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ConnpassService {

    @GET("event/")
    suspend fun eventList(@Query("count") count: Int, @Query("start") start: Int): Response<ConnpassEvent>
}