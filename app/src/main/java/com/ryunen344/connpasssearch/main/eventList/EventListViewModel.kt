package com.ryunen344.connpasssearch.main.eventList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.repository.EventRepository
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EventListViewModel @Inject constructor(private val eventRepository: EventRepository) :
    ViewModel() {

    private var _items: MutableLiveData<List<Event>> = MutableLiveData()
    val items: LiveData<List<Event>>
        get() = _items

    fun loadEventList() = viewModelScope.launch(Dispatchers.IO) {
        loadEventList(0)
    }

    override fun onCleared() {
        LogUtil.d()
        super.onCleared()
    }

    fun loadMoreEventList(currentPage: Int) = viewModelScope.launch(Dispatchers.IO) {
        loadEventList(currentPage)
    }

    fun itemClick(eventId: Int) {
        LogUtil.d("event id = $eventId")
    }

    private suspend fun loadEventList(currentPage: Int) = viewModelScope.launch(Dispatchers.IO) {
        LogUtil.d("currentPage is $currentPage")
        val newItems = eventRepository.getEventList(currentPage).value?.events
        launch(Dispatchers.Main) {
            val value = mutableListOf<Event>()
            _items.value?.let {
                value.addAll(it)
            }
            newItems?.let {
                value.addAll(it)
            }
            _items.value = value
            LogUtil.d("post list")
        }
    }
}