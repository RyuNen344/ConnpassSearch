package com.ryunen344.connpasssearch.feature.main.eventList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.ryunen344.connpasssearch.core.ext.combine
import com.ryunen344.connpasssearch.core.ext.toAppError
import com.ryunen344.connpasssearch.core.ext.toLoadingState
import com.ryunen344.connpasssearch.model.AppError
import com.ryunen344.connpasssearch.model.Event
import com.ryunen344.connpasssearch.model.LoadState
import com.ryunen344.connpasssearch.model.LoadingState
import com.ryunen344.connpasssearch.model.repository.EventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import timber.log.Timber
import timber.log.debug
import javax.inject.Inject

class EventListViewModel @Inject constructor(private val eventRepository: EventRepository) :
    ViewModel() {

    data class UiModel(
        val isLoading: Boolean,
        val error: AppError?,
        val eventList: List<Event>
    ) {
        companion object {
            val EMPTY = UiModel(false, null, emptyList())
        }
    }

    private var eventList: List<Event> = emptyList()

    @ExperimentalCoroutinesApi
    private val eventListLoadStateLiveData: LiveData<LoadState<List<Event>>> = liveData {
        emitSource(
            eventRepository.getEventList(0)
                .toLoadingState()
                .asLiveData()
        )

        try {
            eventRepository.refresh()
        } catch (exception: Exception) {
            reloadEventListLiveData.postValue(LoadingState.Error(exception))
        }
    }
    private val reloadEventListLiveData = MutableLiveData<LoadingState>(LoadingState.Loaded)

    @ExperimentalCoroutinesApi
    val uiModel: LiveData<UiModel> = combine(
        initialValue = UiModel.EMPTY,
        liveData1 = eventListLoadStateLiveData,
        liveData2 = reloadEventListLiveData
    ) { _, loadState, reloadState ->
        Timber.debug { loadState.toString() }
        Timber.debug { loadState.getErrorIfExists().toString() }
        Timber.debug { reloadState.toString() }

        if (loadState is LoadState.Loaded) {
            eventList = loadState.value
        }
        val appError = reloadState.getErrorIfExists()?.toAppError()
            ?: loadState.getErrorIfExists()?.toAppError()

        UiModel(
            isLoading = (loadState.isLoading || reloadState.isLoading) && appError == null,
            error = appError,
            eventList = eventList
        )
    }

    fun loadEventList() = viewModelScope.launch(Dispatchers.IO) {
        loadEventList(0)
    }

    fun onRetry() {
        reloadEventListLiveData.postValue(LoadingState.Loading)
        viewModelScope.launch {
            try {
                eventRepository.refresh()
                reloadEventListLiveData.postValue(LoadingState.Loaded)
            } catch (exception: java.lang.Exception) {
                reloadEventListLiveData.postValue(LoadingState.Error(exception))
            }
        }
    }

    fun loadMoreEventList(currentPage: Int) = viewModelScope.launch(Dispatchers.IO) {
        loadEventList(currentPage)
    }

    fun itemClick(eventId: Int) {
    }

    private suspend fun loadEventList(currentPage: Int) = viewModelScope.launch(Dispatchers.IO) {
        //        val newItems = eventRepository.getEventList(currentPage).value?.events
//        launch(Dispatchers.Main) {
//            val value = mutableListOf<Event>()
//            _items.value?.let {
//                value.addAll(it)
//            }
//            newItems?.let {
//                value.addAll(it)
//            }
//            _items.value = value
//            LogUtil.d("post list")
//        }
    }
}
