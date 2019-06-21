package com.ryunen344.connpasssearch.loco

import com.sys1yagi.loco.core.LocoConfig
import com.sys1yagi.loco.core.Sender
import com.sys1yagi.loco.core.SendingResult
import com.sys1yagi.loco.core.SendingScheduler
import kotlinx.coroutines.delay

class IntervalSendingScheduler(private val interval: Long) : SendingScheduler {
    override suspend fun schedule(
        latestResults: List<Pair<Sender, SendingResult>>,
        config: LocoConfig,
        offer: () -> Unit
    ) {
        delay(interval)
        offer()
    }
}