package com.ryunen344.connpasssearch

import android.content.Context
import androidx.fragment.app.Fragment
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.util.LoggingLifecycleObserver
import com.sys1yagi.loco.core.Loco

abstract class BaseFragment : Fragment() {

    private val loggingLifecycleObserver = LoggingLifecycleObserver()

    override fun onAttach(context: Context) {
        this@BaseFragment.lifecycle.addObserver(loggingLifecycleObserver)
        super.onAttach(context)
        Loco.send(ScreenLog(this.javaClass.simpleName))
    }

    override fun onDestroy() {
        super.onDestroy()
        this@BaseFragment.lifecycle.removeObserver(loggingLifecycleObserver)
    }
}