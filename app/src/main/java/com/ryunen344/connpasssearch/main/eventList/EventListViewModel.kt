package com.ryunen344.connpasssearch.main.eventList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.data.source.EventRepository
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventListViewModel(private val eventRepository: EventRepository) : ViewModel() {

    val items: MutableLiveData<MutableList<Event>> = MutableLiveData()
    private var navigator: EventListNavigator? = null



    fun onCreate() = viewModelScope.launch(Dispatchers.IO) {
        LogUtil.d()
        items.postValue(eventRepository.getEventList().value?.events)
        LogUtil.d("post list")
    }


    fun onActivityDestroyed() {
        LogUtil.d()
        // Clear references to avoid potential memory leaks.
        navigator = null
    }

    override fun onCleared() {
        LogUtil.d()
        super.onCleared()
    }

    fun itemClick(eventId: Int) {
        LogUtil.d("event id = $eventId")
        navigator?.onStartEventDetail(eventId)
    }

    fun setNavigator(navigator: EventListNavigator) {
        LogUtil.d()
        LogUtil.d(navigator.toString())
        this.navigator = navigator
    }

}