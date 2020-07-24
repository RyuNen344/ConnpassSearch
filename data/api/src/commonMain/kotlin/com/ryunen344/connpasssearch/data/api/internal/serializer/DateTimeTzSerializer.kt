package com.ryunen344.connpasssearch.data.api.internal.serializer

import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.ISO8601
import com.soywiz.klock.parse
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.PrimitiveDescriptor
import kotlinx.serialization.PrimitiveKind
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer

@Serializer(forClass = DateTimeTz::class)
object DateTimeTzSerializer : KSerializer<DateTimeTz> {
    override val descriptor: SerialDescriptor =
        PrimitiveDescriptor("DateTimeTz", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: DateTimeTz) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): DateTimeTz {
        return ISO8601
            .IsoDateTimeFormat("YYYY-MM-DDThh:mm:ss±hh:mm", null)
            .parse(decoder.decodeString())
    }
}
