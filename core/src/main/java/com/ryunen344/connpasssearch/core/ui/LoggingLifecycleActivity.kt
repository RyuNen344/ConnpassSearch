package com.ryunen344.connpasssearch.core.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryunen344.connpasssearch.core.util.LoggingLifecycleObserver

abstract class LoggingLifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.lifecycle.addObserver(LoggingLifecycleObserver())
    }
}
