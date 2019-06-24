package com.ryunen344.connpasssearch.main.eventList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ryunen344.connpasssearch.R.layout.fragment_event_list
import com.ryunen344.connpasssearch.util.LogUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventListFragment : Fragment() {

    val eventListViewModel: EventListViewModel by viewModel()

    companion object {
        fun newInstance() = EventListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtil.d()
        return inflater.inflate(fragment_event_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onViewCreated(view, savedInstanceState)
    }
}