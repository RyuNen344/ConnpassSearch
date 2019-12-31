package com.ryunen344.connpasssearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.util.LoggingLifecycleObserver
import com.sys1yagi.loco.core.Loco

abstract class BaseFragment : Fragment() {

    private val loggingLifecycleObserver = LoggingLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this@BaseFragment.lifecycle.addObserver(loggingLifecycleObserver)
        Loco.send(ScreenLog(this.javaClass.simpleName))
    }

    override fun onDestroy() {
        super.onDestroy()
        this@BaseFragment.lifecycle.removeObserver(loggingLifecycleObserver)
    }
}