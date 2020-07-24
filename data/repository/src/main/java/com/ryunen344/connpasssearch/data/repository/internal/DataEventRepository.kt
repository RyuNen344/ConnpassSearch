package com.ryunen344.connpasssearch.data.repository.internal

import com.ryunen344.connpasssearch.data.api.ConnpassApi
import com.ryunen344.connpasssearch.data.api.response.EventItemResponse
import com.ryunen344.connpasssearch.data.api.response.EventTypeResponse
import com.ryunen344.connpasssearch.data.api.response.GroupResponse
import com.ryunen344.connpasssearch.model.Event
import com.ryunen344.connpasssearch.model.EventType
import com.ryunen344.connpasssearch.model.Group
import com.ryunen344.connpasssearch.model.repository.EventRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import timber.log.debug
import javax.inject.Inject

class DataEventRepository @Inject constructor(
    private val connpassApi: ConnpassApi
) : EventRepository {

    @ExperimentalCoroutinesApi
    override suspend fun getEventList(currentPage: Int): Flow<List<Event>> = flow {
        emit(
            connpassApi
                .getEvents(count = 100, start = currentPage + 1)
                .events
                .map(EventItemResponse::toEvent)
        )
    }


    override suspend fun getEvent(eventId: Int): Flow<Event> =
        connpassApi
            .getEvent(eventId = eventId)
            .events
            .onEach { Timber.debug { it.toString() } }
            .map(EventItemResponse::toEvent)
            .asFlow()

    override suspend fun searchEventList(keyword: String, currentPage: Int): Flow<List<Event>> =
        flow {
            emit(
                connpassApi
                    .getEvents(keyword = keyword, count = 100, start = currentPage + 1)
                    .events
                    .onEach { Timber.debug { it.toString() } }
                    .map(EventItemResponse::toEvent)
            )
        }

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

private fun EventItemResponse.toEvent(): Event =
    Event(
        eventId = eventId,
        title = title,
        catch = catch,
        description = description,
        eventUrl = eventUrl,
        hashTag = hashTag,
        startedAt = startedAt,
        endedAt = endedAt,
        limit = limit,
//        eventType = EventType.valueOf(eventType),
        eventType = EventType.PARTICIPATION,
        series = series?.toGroup(),
        address = address,
        place = place,
        lat = lat,
        lon = lon,
        ownerId = ownerId,
        ownerNickname = ownerNickname,
        ownerDisplayName = ownerDisplayName,
        accepted = accepted,
        waiting = waiting,
        updatedAt = updatedAt
    )
