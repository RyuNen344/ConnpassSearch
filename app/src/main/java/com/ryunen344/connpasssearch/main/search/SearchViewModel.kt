package com.ryunen344.connpasssearch.main.search


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.data.Event
import com.ryunen344.connpasssearch.data.source.EventRepository
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val eventRepository: EventRepository) : ViewModel() {

    var _items: MutableList<Event> = mutableListOf()
    val items: MutableLiveData<MutableList<Event>> = MutableLiveData()
    var keyword: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    lateinit var textObserver: Observer<String>
    private var navigator: SearchNavigator? = null


    fun onCreate() = viewModelScope.launch {
        LogUtil.d()
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
        navigator?.let {
            it.onStartEventDetail(eventId)
        }
    }

    fun setNavigator(navigator: SearchNavigator) {
        LogUtil.d()
        this.navigator = navigator
    }

    private suspend fun searchEventList(keyword: String, currentPage: Int) {
        LogUtil.d()
        eventRepository.searchEventList(keyword, currentPage).value?.events?.let {
            _items.addAll(it)
            items.postValue(_items)
            LogUtil.d("post list")
        }
    }

    fun searchEvent(keyword: String) {
        LogUtil.d()
        viewModelScope.launch(Dispatchers.IO) {
            LogUtil.d()
            searchEventList(keyword, 0)
        }
    }
}