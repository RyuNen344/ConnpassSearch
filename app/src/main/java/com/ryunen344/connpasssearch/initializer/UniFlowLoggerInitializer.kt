package com.ryunen344.connpasssearch.initializer

import com.ryunen344.connpasssearch.core.UniFlowTimberLogger
import io.uniflow.core.logger.UniFlowLogger

class UniFlowLoggerInitializer : AppInitializer {
    override fun initialize() {
        UniFlowLogger.init(UniFlowTimberLogger())
    }
}
