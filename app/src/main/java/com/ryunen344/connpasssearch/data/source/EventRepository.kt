package com.ryunen344.connpasssearch.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ryunen344.connpasssearch.data.ConnpassEvent
import com.ryunen344.connpasssearch.di.api.ApiProvider
import com.ryunen344.connpasssearch.util.LogUtil

class EventRepository(private val apiProvider: ApiProvider) {

    private var connpassService = apiProvider.provideConnpassService()

    suspend fun getEventList(): LiveData<ConnpassEvent> {
        LogUtil.d()
        var mutableLiveData: MutableLiveData<ConnpassEvent> = MutableLiveData()
        val response = connpassService.eventList()
        //GlobalScope.launch(Dispatchers.Main) {
        if (response.isSuccessful) {
            response.body()?.events?.size?.let { LogUtil.d("event list size is $it") }
            mutableLiveData.postValue(response.body())
        } else {
            LogUtil.d(response.errorBody().toString())
        }
        //}

        return mutableLiveData
    }
}


