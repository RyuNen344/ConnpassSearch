package com.ryunen344.connpasssearch.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ryunen344.connpasssearch.data.http.response.EventResponse
import com.ryunen344.connpasssearch.service.ConnpassService
import com.ryunen344.connpasssearch.util.LogUtil
import javax.inject.Inject

class EventRepository @Inject constructor(private val connpassService: ConnpassService) {

    suspend fun getEventList(currentPage: Int): LiveData<EventResponse> {
        LogUtil.d("currentPage is $currentPage")
        val data = connpassService.eventList(100, 100 * currentPage)
        return MutableLiveData(data)
    }

    suspend fun getEvent(eventId: Int): LiveData<EventResponse> {
        LogUtil.d("event id = $eventId")
        val data = connpassService.event(eventId)
        return MutableLiveData(data)
    }

    suspend fun searchEventList(keyword: String, currentPage: Int): LiveData<EventResponse> {
        LogUtil.d("currentPage is $currentPage")
        val data = connpassService.search(keyword, 100, 100 * currentPage)
        return MutableLiveData(data)
    }
}


