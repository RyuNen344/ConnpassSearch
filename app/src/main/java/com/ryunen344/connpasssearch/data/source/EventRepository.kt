package com.ryunen344.connpasssearch.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ryunen344.connpasssearch.data.ConnpassEvent
import com.ryunen344.connpasssearch.di.api.ApiProvider
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class EventRepository(private val apiProvider: ApiProvider) {

    private var connpassService = apiProvider.provideConnpassService()

    suspend fun getEventList(currentPage: Int): LiveData<ConnpassEvent> {
        LogUtil.d()
        var mutableLiveData: MutableLiveData<ConnpassEvent> = MutableLiveData()
        runBlocking {
            LogUtil.d("currentPage is $currentPage")
            var response: Response<ConnpassEvent> = connpassService.eventList(100, 100 * currentPage)
            if (response.isSuccessful) {
                response.body()?.events?.size?.let { LogUtil.d("event list size is $it") }
                mutableLiveData.postValue(response.body()).also { LogUtil.d("post data") }
            } else {
                LogUtil.d(response.errorBody().toString())
            }
        }
        return mutableLiveData
    }

    suspend fun getEvent(eventId: Int): LiveData<ConnpassEvent> {
        LogUtil.d("event id = $eventId")
        var mutableLiveData: MutableLiveData<ConnpassEvent> = MutableLiveData()
        if (eventId == 0) return mutableLiveData
        runBlocking {
            LogUtil.d()
            var response: Response<ConnpassEvent> = connpassService.event(eventId)
            if (response.isSuccessful) {
                mutableLiveData.postValue(response.body()).also { LogUtil.d("post data") }
            } else {
                LogUtil.d(response.errorBody().toString())
            }
        }
        return mutableLiveData
    }

    suspend fun searchEventList(keyword: String, currentPage: Int): LiveData<ConnpassEvent> {
        LogUtil.d()
        var mutableLiveData: MutableLiveData<ConnpassEvent> = MutableLiveData()
        runBlocking {
            LogUtil.d("currentPage is $currentPage")
            var response: Response<ConnpassEvent> = connpassService.search(keyword, 100, 100 * currentPage)
            if (response.isSuccessful) {
                response.body()?.events?.size?.let { LogUtil.d("event list size is $it") }
                mutableLiveData.postValue(response.body()).also { LogUtil.d("post data") }
            } else {
                LogUtil.d(response.errorBody().toString())
            }
        }
        return mutableLiveData
    }

}


