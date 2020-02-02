package com.ryunen344.connpasssearch.data.api.internal.response

import com.ryunen344.connpasssearch.data.api.response.GroupResponse
import kotlinx.serialization.Serializable

@Serializable
internal data class GroupResponseImpl(
    override val id: Int,
    override val title: String,
    override val url: String
) : GroupResponse
