package com.ryunen344.connpasssearch.core.ext

import com.ryunen344.connpasssearch.model.AppError
import io.ktor.client.features.ResponseException
import io.ktor.util.cio.ChannelReadException
import kotlinx.coroutines.TimeoutCancellationException

fun Throwable?.toAppError(): AppError? {
    return when (this) {
        null -> null
        is AppError -> this
        is ResponseException ->
            return AppError.ApiException.ServerException(this)
        is ChannelReadException ->
            return AppError.ApiException.NetworkException(this)
        is TimeoutCancellationException -> AppError.ApiException.NetworkException(this)
        else -> AppError.UnknownException(this)
    }
}

//@StringRes
fun AppError.stringRes() = when (this) {
    is AppError.ApiException.NetworkException -> "R.string.error_network"
    is AppError.ApiException.ServerException -> "R.string.error_server"
    is AppError.ApiException.UnknownException -> "R.string.error_unknown"
    is AppError.UnknownException -> "R.string.error_unknown"
}
