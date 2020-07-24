package com.ryunen344.connpasssearch.core.ext

import com.ryunen344.connpasssearch.model.LoadState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

@ExperimentalCoroutinesApi
fun <T> Flow<T>.toLoadingState(): Flow<LoadState<T>> {
    return map<T, LoadState<T>> { LoadState.Loaded(it) }
        .onStart {
            @Suppress("UNCHECKED_CAST")
            emit(LoadState.Loading as LoadState<T>)
        }
        .catch { e ->
            emit(LoadState.Error<T>(e))
        }
}

suspend inline fun <T> Flow<T>.dropWhileIndexed(
    crossinline predicate: suspend (index: Int, value: T) -> Boolean
): Flow<T> = flow {
    var index = 0
    var matched = false
    collect { value ->
        if (matched) {
            emit(value)
        } else if (!predicate(index, value)) {
            matched = true
            emit(value)
        }
        index++
    }
}
