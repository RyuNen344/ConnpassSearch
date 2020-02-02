package com.ryunen344.connpasssearch.core.util

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTimeTz
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
        encoder.encodeString(obj.format("yyyy-MM-dd'T'HH:mm:ssZ"))
    }

    override fun deserialize(decoder: Decoder): DateTimeTz {
        return DateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(decoder.decodeString())
    }
}
