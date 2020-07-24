package com.ryunen344.connpasssearch.data.api.di

import com.ryunen344.connpasssearch.data.api.ConnpassLoggingConfig
import com.ryunen344.connpasssearch.data.api.apiEndpoint
import com.ryunen344.connpasssearch.data.api.internal.KtorConnpassApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.Ios
import io.ktor.client.features.UserAgent
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.koin.core.qualifier.named
import org.koin.dsl.module
import platform.Foundation.NSBundle

actual val apiModule = module {
    single { KtorConnpassApi(get(), get(named("endPoint"))) }
    single {
        HttpClient(Ios) {
            install(UserAgent) {
                agent =
                    "ConnpassSearch/${NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleShortVersionString")} gzip"
            }
            install(Logging) {
                level = ConnpassLoggingConfig.level
                logger = ConnpassLoggingConfig.logger
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
