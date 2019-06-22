package com.ryunen344.connpasssearch.service

import com.ryunen344.connpasssearch.data.ConnpassEvent
import retrofit2.Call
import retrofit2.http.GET

interface ConnpassService {

    @GET
    fun eventList(): Call<ConnpassEvent>
}