package com.ryunen344.connpasssearch.main.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.repository.EventRepository
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val eventRepository: EventRepository) :
    ViewModel() {

    var eventId: Int = 0
    var items: MutableLiveData<Event> = MutableLiveData()

    fun onCreate() = viewModelScope.launch(Dispatchers.IO) {
        LogUtil.d()
        loadEvent()
    }

    fun onActivityDestroyed() {
        LogUtil.d()
        // Clear references to avoid potential memory leaks.
    }

    override fun onCleared() {
        LogUtil.d()
        super.onCleared()
    }

    private suspend fun loadEvent() {
        LogUtil.d()
        eventRepository.getEvent(eventId).value?.events?.let {
            LogUtil.d(it.toString())
            items.postValue(it.first())
            LogUtil.d("post data")
        }
        LogUtil.d()
    }
}