package com.ryunen344.connpasssearch.di.api

import dagger.Module

@Module
class ApiModule {

//    @Singleton
//    @Provides
//    fun provideOkHttpClient(): OkHttpClient {
//        val logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
//            override fun log(message: String) {
//                LogUtil.d(message)
//            }
//        })
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        return OkHttpClient.Builder()
//            .addInterceptor(logging)
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl("https://connpass.com/api/v1/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideConnpassService(retrofit: Retrofit): ConnpassService =
//        retrofit.create(ConnpassService::class.java)
}
