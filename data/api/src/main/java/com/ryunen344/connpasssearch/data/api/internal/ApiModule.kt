package com.ryunen344.connpasssearch.data.api.internal

import com.ryunen344.connpasssearch.data.api.BuildConfig
import com.ryunen344.connpasssearch.data.api.ConnpassApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named

@Module(includes = [ApiModule.Providers::class])
internal abstract class ApiModule {
    @Binds
    abstract fun ConnpassApi(impl: InjectableKtorConnpassApi): ConnpassApi

    @Module
    internal object Providers {
        @Provides
        fun httpClient(): HttpClient {
            return HttpClient(OkHttp) {
                engine {
                    if (BuildConfig.DEBUG) {
                        addInterceptor(
                            HttpLoggingInterceptor().apply {
                                level = HttpLoggingInterceptor.Level.BODY

                            }
                        )
                    }
                    addInterceptor(UserAgentInterceptor())
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer(
                        Json(
                            JsonConfiguration.Stable.copy(unquoted = true)
                        )
                    )
                }
            }
        }

        @Provides
        @Named("apiEndpoint")
        fun apiEndpoint(): String = com.ryunen344.connpasssearch.data.api.internal.apiEndpoint()
    }
}
