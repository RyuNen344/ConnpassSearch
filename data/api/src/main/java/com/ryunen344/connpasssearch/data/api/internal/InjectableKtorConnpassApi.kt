package com.ryunen344.connpasssearch.data.api.internal

import io.ktor.client.HttpClient
import javax.inject.Inject
import javax.inject.Named

internal class InjectableKtorConnpassApi @Inject constructor(
    httpClient: HttpClient,
    @Named("apiEndpoint") apiEndpoint: String
) : KtorConnpassApi(httpClient, apiEndpoint, null)
