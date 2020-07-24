package com.ryunen344.connpasssearch.data.api.di

import com.ryunen344.connpasssearch.data.api.BuildConfig
import com.ryunen344.connpasssearch.data.api.apiEndpoint
import com.ryunen344.connpasssearch.data.api.internal.KtorConnpassApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.UserAgent
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.EMPTY
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.SIMPLE
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val apiModule = module {
    single { KtorConnpassApi(get(), get(named("endPoint"))) }
    single {
        HttpClient(OkHttp) {
            install(UserAgent) {
                agent = "ConnpassSearch/${BuildConfig.VERSION_NAME} gzip"
            }
            install(Logging) {
                if (BuildConfig.DEBUG) {
                    logger = Logger.Companion.SIMPLE
                    level = LogLevel.BODY
                } else {
                    logger = Logger.Companion.EMPTY
                    level = LogLevel.NONE
                }
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    Json(
                        JsonConfiguration.Stable
                    )
                )
            }
        }
    }
    single(named("endPoint")) { apiEndpoint() }
}
