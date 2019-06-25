package com.ryunen344.connpasssearch.data.source

import androidx.lifecycle.liveData
import com.ryunen344.connpasssearch.data.ConnpassEvent
import com.ryunen344.connpasssearch.di.api.ApiProvider

class EventRepository(apiProvider: ApiProvider) {

    private var connpassService = apiProvider.provideConnpassService()

    fun getEventList() = liveData<ConnpassEvent> {
        val response = connpassService.eventList()
        if (response.isSuccessful) {
            emit(response.body()!!)
        }
    }

}

