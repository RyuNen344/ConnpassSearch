package com.ryunen344.connpasssearch.feature.main.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.model.Event
import com.ryunen344.connpasssearch.model.repository.EventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val eventRepository: EventRepository) :
    ViewModel() {

    var _items: MutableList<Event> = mutableListOf()
    val items: MutableLiveData<MutableList<Event>> = MutableLiveData()
    var keyword: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    lateinit var textObserver: Observer<String>
    private var navigator: SearchNavigator? = null

    fun onActivityDestroyed() {
        // Clear references to avoid potential memory leaks.
        navigator = null
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun itemClick(eventId: Int) {
        navigator?.let {
            it.onStartEventDetail(eventId)
        }
    }

    fun setNavigator(navigator: SearchNavigator) {
        this.navigator = navigator
    }

    private suspend fun searchEventList(keyword: String, currentPage: Int) {
//        eventRepository.searchEventList(keyword, currentPage).value?.events?.let {
//            _items.addAll(it)
//            items.postValue(_items)
//        }
    }

    fun searchEvent(keyword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            searchEventList(keyword, 0)
        }
    }

    fun clearEvent() {
        if (_items.size != 0) {
            _items.clear()
            items.postValue(_items)
        }
    }
}
