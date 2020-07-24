package com.ryunen344.connpasssearch.data.api

import com.ryunen344.connpasssearch.data.api.internal.KtorConnpassApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.UserAgent
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val apiModule = module {
    single { KtorConnpassApi(get(), get(named("endPoint"))) }
    single {
        HttpClient(OkHttp) {
            engine {
                if (BuildConfig.DEBUG) {
                    addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.HEADERS
                        }
                    )
                }
            }
            install(UserAgent) {
                agent = "ConnpassSearch/${BuildConfig.VERSION_NAME} gzip"
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                    }
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
