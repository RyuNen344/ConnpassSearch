package com.ryunen344.connpasssearch.core.util

import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.ISO8601
import com.soywiz.klock.parse
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName

@Serializer(forClass = DateTimeTz::class)
object DateTimeTzSerializer : KSerializer<DateTimeTz> {
    override val descriptor: SerialDescriptor =
        StringDescriptor.withName("DateTimeTz")

    override fun serialize(encoder: Encoder, obj: DateTimeTz) {
        encoder.encodeString(obj.toString())
    }

    override fun deserialize(decoder: Decoder): DateTimeTz {
        return ISO8601
            .IsoDateTimeFormat("YYYY-MM-DDThh:mm:ss±hh:mm", null)
            .parse(decoder.decodeString())
    }
}
