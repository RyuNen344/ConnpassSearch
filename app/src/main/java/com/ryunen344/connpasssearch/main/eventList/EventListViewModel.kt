package com.ryunen344.connpasssearch.main.eventList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.data.source.EventRepository
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.launch

class EventListViewModel(private val eventRepository: EventRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
        }
    }

    val items: LiveData<MutableList<Event>> = MutableLiveData<MutableList<Event>>().apply {
        LogUtil.d()
        value = ArrayList(0)
    }

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading


    override fun onCleared() {
        LogUtil.d()
        super.onCleared()
    }

    fun start(taskId: String?) {
        _dataLoading.value?.let { isLoading ->
            // Already loading, ignore.
            if (isLoading) return
        }
        _dataLoading.value = true

        eventRepository.getEventList()
    }


}