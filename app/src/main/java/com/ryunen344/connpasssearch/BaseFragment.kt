package com.ryunen344.connpasssearch

import android.content.Context
import androidx.fragment.app.Fragment
import com.ryunen344.connpasssearch.util.LoggingLifecycleObserver

abstract class BaseFragment : Fragment() {

    private val loggingLifecycleObserver = LoggingLifecycleObserver()

    override fun onAttach(context: Context) {
        this@BaseFragment.lifecycle.addObserver(loggingLifecycleObserver)
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
        this@BaseFragment.lifecycle.removeObserver(loggingLifecycleObserver)
    }
}