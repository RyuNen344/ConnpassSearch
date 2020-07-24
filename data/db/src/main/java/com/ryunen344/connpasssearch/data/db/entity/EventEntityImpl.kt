package com.ryunen344.connpasssearch.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.soywiz.klock.DateTimeTz

@Entity(tableName = "event")
internal data class EventEntityImpl(
    @PrimaryKey
    @ColumnInfo(name = "event_id")
    override val eventId: Int,

    @ColumnInfo(name = "title")
    override val title: String,

    @ColumnInfo(name = "catch")
    override val catch: String,

    @ColumnInfo(name = "description")
    override val description: String,

    @ColumnInfo(name = "event_url")
    override val eventUrl: String,

    @ColumnInfo(name = "hash_tag")
    override val hashTag: String,

    @ColumnInfo(name = "started_at")
    override val startedAt: DateTimeTz,

    @ColumnInfo(name = "ended_at")
    override val endedAt: DateTimeTz,

    @ColumnInfo(name = "limit")
    override val limit: Int,

    @ColumnInfo(name = "event_type")
    override val eventType: String,

    @Embedded(prefix = "group_")
    override val series: GroupEntityImpl?,

    @ColumnInfo(name = "address")
    override val address: String,

    @ColumnInfo(name = "place")
    override val place: String,

    @ColumnInfo(name = "lat")
    override val lat: Float,

    @ColumnInfo(name = "lon")
    override val lon: Float,

    @ColumnInfo(name = "owner_id")
    override val ownerId: Int,

    @ColumnInfo(name = "owner_nickname")
    override val ownerNickname: String,

    @ColumnInfo(name = "owner_display_name")
    override val ownerDisplayName: String,

    @ColumnInfo(name = "accepted")
    override val accepted: Int,

    @ColumnInfo(name = "waiting")
    override val waiting: Int,

    @ColumnInfo(name = "updated_at")
    override val updatedAt: DateTimeTz
) : EventEntity
