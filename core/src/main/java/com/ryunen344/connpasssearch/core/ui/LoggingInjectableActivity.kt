package com.ryunen344.connpasssearch.core.ui

import android.os.Bundle
import com.ryunen344.connpasssearch.core.util.LoggingLifecycleObserver
import dagger.android.support.DaggerAppCompatActivity

abstract class LoggingInjectableActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.lifecycle.addObserver(LoggingLifecycleObserver())
    }
}
