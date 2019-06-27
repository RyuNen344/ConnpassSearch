package com.ryunen344.connpasssearch.main.eventList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.data.source.EventRepository
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventListViewModel(private val eventRepository: EventRepository) : ViewModel() {

    private val _items = MutableLiveData<MutableList<Event>>()
    val items: LiveData<MutableList<Event>>
        get() = _items.apply { LogUtil.d() }

    fun onCreate() = viewModelScope.launch(Dispatchers.IO) {
        LogUtil.d()
        val connpassEvent = eventRepository.getEventList()
        _items.postValue(connpassEvent.value?.events)
    }


    override fun onCleared() {
        LogUtil.d()
        super.onCleared()
    }

}