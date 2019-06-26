package com.ryunen344.connpasssearch.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ryunen344.connpasssearch.data.ConnpassEvent
import com.ryunen344.connpasssearch.di.api.ApiProvider
import com.ryunen344.connpasssearch.util.LogUtil

class EventRepository(private val apiProvider: ApiProvider) {

    private var connpassService = apiProvider.provideConnpassService()

    fun getEventList(): LiveData<ConnpassEvent> {
        LogUtil.d()
        LogUtil.d(apiProvider.provideRetrofit().baseUrl())
        var mutableLiveData: MutableLiveData<ConnpassEvent> = MutableLiveData()
        val deferred = connpassService.eventList()
//        val response = connpassService.eventList()
//        if (response.isSuccessful) {
//            LogUtil.d(response.body().toString())
//            mutableLiveData.value = response.body()
//
//        } else {
//            LogUtil.d(response.errorBody().toString())
//        }
        mutableLiveData.value = deferred.getCompleted()
        return mutableLiveData
//        if (response.isSuccessful) {
//            LogUtil.d(response.body().toString())
//            emit(response.body()!!)
//        }
    }
}


