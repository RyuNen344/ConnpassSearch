package com.ryunen344.connpasssearch.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ryunen344.connpasssearch.data.http.response.EventResponse
import com.ryunen344.connpasssearch.service.ConnpassService
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import retrofit2.Retrofit

class EventRepository {

    private var connpassService: ConnpassService =
        Retrofit.Builder().build().create(ConnpassService::class.java)

    suspend fun getEventList(currentPage: Int): LiveData<EventResponse> {
        LogUtil.d()
        var mutableLiveData: MutableLiveData<EventResponse> = MutableLiveData()
        runBlocking {
            LogUtil.d("currentPage is $currentPage")
            var response: Response<EventResponse> =
                connpassService.eventList(100, 100 * currentPage)
            if (response.isSuccessful) {
                response.body()?.events?.size?.let { LogUtil.d("event list size is $it") }
                mutableLiveData.postValue(response.body()).also { LogUtil.d("post data") }
            } else {
                LogUtil.d(response.errorBody().toString())
            }
        }
        return mutableLiveData
    }

    suspend fun getEvent(eventId: Int): LiveData<EventResponse> {
        LogUtil.d("event id = $eventId")
        var mutableLiveData: MutableLiveData<EventResponse> = MutableLiveData()
        if (eventId == 0) return mutableLiveData
        runBlocking {
            LogUtil.d()
            var response: Response<EventResponse> = connpassService.event(eventId)
            if (response.isSuccessful) {
                mutableLiveData.postValue(response.body()).also { LogUtil.d("post data") }
            } else {
                LogUtil.d(response.errorBody().toString())
            }
        }
        return mutableLiveData
    }

    suspend fun searchEventList(keyword: String, currentPage: Int): LiveData<EventResponse> {
        LogUtil.d()
        var mutableLiveData: MutableLiveData<EventResponse> = MutableLiveData()
        runBlocking {
            LogUtil.d("currentPage is $currentPage")
            var response: Response<EventResponse> =
                connpassService.search(keyword, 100, 100 * currentPage)
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


