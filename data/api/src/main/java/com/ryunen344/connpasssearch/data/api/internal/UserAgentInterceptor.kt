package com.ryunen344.connpasssearch.data.api.internal

import com.ryunen344.connpasssearch.data.api.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class UserAgentInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().apply {
                addHeader("User-Agent", "ConnpassSearch/${BuildConfig.VERSION_CODE} gzip")
            }.build()
        )
    }
}
