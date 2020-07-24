package com.ryunen344.connpasssearch.data.api.internal

import com.ryunen344.connpasssearch.data.api.ConnpassApi
import com.ryunen344.connpasssearch.data.api.internal.response.EventResponseImpl
import com.ryunen344.connpasssearch.data.api.response.EventResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

internal open class KtorConnpassApi constructor(
    private val httpClient: HttpClient,
    private val apiEndpoint: String
) : ConnpassApi {

    private val json = Json(JsonConfiguration.Stable)

    override suspend fun getEvents(keyword: String?, count: Int, start: Int): EventResponse {
        val rawResponse = httpClient.get<String> {
            url(
                if (keyword == null) {
                    "$apiEndpoint?count=$count&start=$start"
                } else {
                    "$apiEndpoint?keyword=$keyword&count=$count&start=$start"
                }
            )
            accept(ContentType.Application.Json)
        }
        return json.parse(EventResponseImpl.serializer(), rawResponse)
    }

    override suspend fun getEvents(
        keyword: String?,
        count: Int,
        start: Int,
        callback: (response: EventResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    ) {
        runCatching {
            getEvents(keyword, count, start)
        }.onSuccess {
            callback(it)
        }.onFailure {
            onError(it)
        }
    }

    override suspend fun getEvent(eventId: Int): EventResponse {
        val rawResponse = httpClient.get<String> {
            url("$apiEndpoint/?event_id=$eventId")
            accept(ContentType.Application.Json)
        }
        return json.parse(EventResponseImpl.serializer(), rawResponse)
    }

    override suspend fun getEvent(
        eventId: Int,
        callback: (response: EventResponse) -> Unit,
        onError: (error: Throwable) -> Unit
    ) {
        runCatching {
            getEvent(eventId)
        }.onSuccess {
            callback(it)
        }.onFailure {
            onError(it)
        }
    }
}
