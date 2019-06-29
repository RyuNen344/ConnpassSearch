package com.ryunen344.connpasssearch.main.eventList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.data.source.EventRepository
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EventListViewModel(private val eventRepository: EventRepository) : ViewModel() {

    val items: MutableLiveData<MutableList<Event>> = MutableLiveData<MutableList<Event>>()

    fun onCreate() = GlobalScope.launch {
        LogUtil.d()
        items.postValue(eventRepository.getEventList().value?.events)
//        LogUtil.d(connpassEvent.value?.events.toString())
//        _items.value = connpassEvent.value?.events

    }


    override fun onCleared() {
        LogUtil.d()
        super.onCleared()
    }

}