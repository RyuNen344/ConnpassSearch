package com.ryunen344.connpasssearch.data.api

import io.ktor.client.features.logging.EMPTY
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger

object ConnpassLoggingConfig {
    val logger: Logger = Logger.EMPTY
    val level: LogLevel = LogLevel.NONE
}
