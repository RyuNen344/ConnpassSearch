package com.ryunen344.connpasssearch.data.api.internal

import com.ryunen344.connpasssearch.data.api.ConnpassApi
import com.ryunen344.connpasssearch.data.api.internal.response.EventResponseImpl
import com.ryunen344.connpasssearch.data.api.response.EventResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.ContentType
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlin.coroutines.CoroutineContext

internal open class KtorConnpassApi constructor(
    private val httpClient: HttpClient,
    private val apiEndpoint: String,
    private val coroutineDispatcherForCallback: CoroutineContext?
) : ConnpassApi {
    private val json = Json(JsonConfiguration.Stable)
    @ImplicitReflectionSerializer
    override suspend fun getEvents(keyword: String?, count: Int, start: Int): EventResponse {
        val rawResponse = httpClient.get<String> {
            url("$apiEndpoint/?keyword=$keyword&count=$count&start=$start")
            accept(ContentType.Application.Json)
        }

        return json.parse(EventResponseImpl.serializer(), rawResponse)
    }

    @ImplicitReflectionSerializer
    override fun getEvents(
        keyword: String?,
        count: Int,
        start: Int,
        callback: (response: EventResponse) -> Unit,
        onError: (error: Exception) -> Unit
    ) {
        GlobalScope.launch(requireNotNull(coroutineDispatcherForCallback)) {
            try {
                val response = getEvents(keyword, count, start)
                callback(response)
            } catch (ex: Exception) {
                onError(ex)
            }
        }
    }

    @ImplicitReflectionSerializer
    override fun getEventsAsync(keyword: String?, count: Int, start: Int): Deferred<EventResponse> =
        GlobalScope.async(requireNotNull(coroutineDispatcherForCallback)) {
            getEvents(keyword, count, start)
        }

    override suspend fun getEvent(eventId: Int): EventResponse {
        val rawResponse = httpClient.get<String> {
            url("$apiEndpoint/?event_id=$eventId")
            accept(ContentType.Application.Json)
        }
        return json.parse(EventResponseImpl.serializer(), rawResponse)
    }

    override fun getEvent(
        eventId: Int,
        callback: (response: EventResponse) -> Unit,
        onError: (error: Exception) -> Unit
    ) {
        GlobalScope.launch(requireNotNull(coroutineDispatcherForCallback)) {
            try {
                val response = getEvent(eventId)
                callback(response)
            } catch (ex: Exception) {
                onError(ex)
            }
        }
    }

    override fun getEventAsync(eventId: Int): Deferred<EventResponse> =
        GlobalScope.async(requireNotNull(coroutineDispatcherForCallback)) {
            getEvent(eventId)
        }
}
