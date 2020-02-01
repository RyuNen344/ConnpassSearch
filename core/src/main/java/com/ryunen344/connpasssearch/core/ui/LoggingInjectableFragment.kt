package com.ryunen344.connpasssearch.core.ui

import android.content.Context
import com.ryunen344.connpasssearch.core.util.LoggingLifecycleObserver
import dagger.android.support.DaggerFragment

abstract class LoggingInjectableFragment : DaggerFragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.lifecycle.addObserver(LoggingLifecycleObserver())
    }
}
