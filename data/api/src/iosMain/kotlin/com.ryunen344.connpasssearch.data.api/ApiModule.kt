package com.ryunen344.connpasssearch.data.api

import com.ryunen344.connpasssearch.data.api.internal.KtorConnpassApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val apiModule = module {
    single { KtorConnpassApi(get(), get(named("endPoint"))) }
    single {
        HttpClient(Ios) {
            install(UserAgent) {
                agent = "ConnpassSearch/${BuildConfig.VERSION_NAME} gzip"
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
