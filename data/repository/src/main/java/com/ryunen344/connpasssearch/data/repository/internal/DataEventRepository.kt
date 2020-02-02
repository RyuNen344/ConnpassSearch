package com.ryunen344.connpasssearch.data.repository.internal

import com.ryunen344.connpasssearch.data.api.ConnpassApi
import com.ryunen344.connpasssearch.data.api.response.EventTypeResponse
import com.ryunen344.connpasssearch.data.api.response.GroupResponse
import com.ryunen344.connpasssearch.model.Event
import com.ryunen344.connpasssearch.model.EventType
import com.ryunen344.connpasssearch.model.Group
import com.ryunen344.connpasssearch.model.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import timber.log.Timber
import timber.log.debug
import javax.inject.Inject

class DataEventRepository @Inject constructor(
    private val connpassApi: ConnpassApi
) : EventRepository {

    override suspend fun getEventList(currentPage: Int): Flow<Event> =
        connpassApi
            .getEvents(count = 100, start = currentPage + 1)
            .events
            .map {
                Event(
                    eventId = it.eventId,
                    title = it.title,
                    catch = it.catch,
                    description = it.description,
                    eventUrl = it.eventUrl,
                    hashTag = it.hashTag,
                    startedAt = it.startedAt,
                    endedAt = it.endedAt,
                    limit = it.limit,
                    eventType = it.eventType.toEventType(),
                    series = it.series.toGroup(),
                    address = it.address,
                    place = it.place,
                    lat = it.lat,
                    lon = it.lon,
                    ownerId = it.ownerId,
                    ownerNickname = it.ownerNickname,
                    ownerDisplayName = it.ownerDisplayName,
                    accepted = it.accepted,
                    waiting = it.waiting,
                    updatedAt = it.updatedAt
                )
            }
            .asFlow()

    override suspend fun getEvent(eventId: Int): Flow<Event> =
        connpassApi
            .getEvent(eventId = eventId)
            .events
            .map {
                Event(
                    eventId = it.eventId,
                    title = it.title,
                    catch = it.catch,
                    description = it.description,
                    eventUrl = it.eventUrl,
                    hashTag = it.hashTag,
                    startedAt = it.startedAt,
                    endedAt = it.endedAt,
                    limit = it.limit,
                    eventType = it.eventType.toEventType(),
                    series = it.series.toGroup(),
                    address = it.address,
                    place = it.place,
                    lat = it.lat,
                    lon = it.lon,
                    ownerId = it.ownerId,
                    ownerNickname = it.ownerNickname,
                    ownerDisplayName = it.ownerDisplayName,
                    accepted = it.accepted,
                    waiting = it.waiting,
                    updatedAt = it.updatedAt
                )
            }
            .asFlow()

    override suspend fun searchEventList(keyword: String, currentPage: Int): Flow<Event> =
        connpassApi
            .getEvents(keyword = keyword, count = 100, start = currentPage + 1)
            .events
            .map {
                Event(
                    eventId = it.eventId,
                    title = it.title,
                    catch = it.catch,
                    description = it.description,
                    eventUrl = it.eventUrl,
                    hashTag = it.hashTag,
                    startedAt = it.startedAt,
                    endedAt = it.endedAt,
                    limit = it.limit,
                    eventType = it.eventType.toEventType(),
                    series = it.series.toGroup(),
                    address = it.address,
                    place = it.place,
                    lat = it.lat,
                    lon = it.lon,
                    ownerId = it.ownerId,
                    ownerNickname = it.ownerNickname,
                    ownerDisplayName = it.ownerDisplayName,
                    accepted = it.accepted,
                    waiting = it.waiting,
                    updatedAt = it.updatedAt
                )
            }
            .asFlow()

    override suspend fun refresh() {
        Timber.debug { "TBD" }
    }
}

private fun EventTypeResponse.toEventType(): EventType {
    if (this.participation != null) return EventType.PARTICIPATION
    if (this.advertisement != null) return EventType.ADVERTISEMENT
    return EventType.PARTICIPATION
}

private fun GroupResponse.toGroup(): Group = Group(id, title, url)
