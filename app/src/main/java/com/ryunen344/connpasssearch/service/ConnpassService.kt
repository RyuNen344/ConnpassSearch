package com.ryunen344.connpasssearch.service

import com.ryunen344.connpasssearch.data.http.response.EventResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ConnpassService {

    @GET("event/")
    suspend fun eventList(@Query("count") count: Int, @Query("start") start: Int): Response<EventResponse>

    @GET("event/")
    suspend fun event(@Query("event_id") event_id: Int): Response<EventResponse>

    @GET("event/")
    suspend fun search(@Query("keyword") keyword: String, @Query("count") count: Int, @Query("start") start: Int): Response<EventResponse>
}