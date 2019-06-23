package com.ryunen344.connpasssearch.main.eventList

import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventListFragment : Fragment() {

    val eventListViewModel: EventListViewModel by viewModel()

    companion object {
        fun newInstance() = EventListFragment()
    }

}