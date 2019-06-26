package com.ryunen344.connpasssearch.di.api

import com.google.gson.Gson
import com.ryunen344.connpasssearch.service.ConnpassService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider {

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl("https://connpass.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            //.addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun provideConnpassService(): ConnpassService {
        return provideRetrofit().create(ConnpassService::class.java)
    }


}