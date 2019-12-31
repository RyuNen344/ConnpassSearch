package com.ryunen344.connpasssearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.util.LoggingLifecycleObserver
import com.sys1yagi.loco.core.Loco

abstract class BaseActivity : AppCompatActivity() {

    private val loggingLifecycleObserver = LoggingLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this@BaseActivity.lifecycle.addObserver(loggingLifecycleObserver)
        Loco.send(ScreenLog(this.javaClass.simpleName))
    }

    override fun onDestroy() {
        super.onDestroy()
        this@BaseActivity.lifecycle.removeObserver(loggingLifecycleObserver)
    }
}