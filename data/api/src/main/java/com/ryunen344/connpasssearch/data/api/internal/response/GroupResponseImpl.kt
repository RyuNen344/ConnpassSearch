package com.ryunen344.connpasssearch.data.api.internal.response

import com.ryunen344.connpasssearch.data.api.response.GroupResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("series")
data class GroupResponseImpl(
    @SerialName("id")
    override val id: Int,
    @SerialName("title")
    override val title: String,
    @SerialName("url")
    override val url: String
) : GroupResponse

@Serializable
data class Demo(
    val series: GroupResponseImpl
)
