package com.ryunen344.connpasssearch.data.db.entity.mapper

import androidx.room.TypeConverter
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.ISO8601
import com.soywiz.klock.parse

class DateTimeTzConverter {
    @TypeConverter
    fun fromString(value: String?): DateTimeTz? {
        return if (value == null) null else
            ISO8601
                .IsoDateTimeFormat("YYYY-MM-DDThh:mm:ss±hh:mm", null)
                .parse(value)
    }

    @TypeConverter
    fun toString(value: DateTimeTz?): String? {
        return value?.toString()
    }
}
