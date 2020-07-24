package com.ryunen344.connpasssearch.data.api

import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.SIMPLE

object ConnpassLoggingConfig {
    val logger: Logger = Logger.SIMPLE
    val level: LogLevel = LogLevel.BODY
}
