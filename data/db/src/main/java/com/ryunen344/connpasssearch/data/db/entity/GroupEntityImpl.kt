package com.ryunen344.connpasssearch.data.db.entity

import androidx.room.ColumnInfo

data class GroupEntityImpl(
    @ColumnInfo(name = "id")
    override val id: Int,
    @ColumnInfo(name = "title")
    override val title: String,
    @ColumnInfo(name = "url")
    override val url: String
) : GroupEntity
