package com.ryunen344.connpasssearch.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.data.source.EventRepository
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val eventRepository: EventRepository) : ViewModel() {

    var eventId: Int = 0
    var items: MutableLiveData<Event> = MutableLiveData()
    private var navigator: DetailNavigator? = null


    fun onCreate() = viewModelScope.launch(Dispatchers.IO) {
        LogUtil.d()
        loadEvent()
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

    fun setNavigator(navigator: DetailNavigator) {
        LogUtil.d()
        this.navigator = navigator
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