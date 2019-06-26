package com.ryunen344.connpasssearch.main.eventList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryunen344.connpasssearch.R.layout.fragment_event_list
import com.ryunen344.connpasssearch.databinding.FragmentEventListBinding
import com.ryunen344.connpasssearch.main.EventListAdapter
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.android.synthetic.main.fragment_event_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventListFragment : Fragment() {

    private lateinit var binding: FragmentEventListBinding
    val eventListViewModel: EventListViewModel by viewModel()

    companion object {
        fun newInstance() = EventListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtil.d()
        binding = DataBindingUtil.inflate(inflater, fragment_event_list, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onActivityCreated(savedInstanceState)


        val layoutManager = LinearLayoutManager(context)

        main_event_list.apply {
            this.layoutManager = layoutManager
            this.setHasFixedSize(true)
            this.adapter = EventListAdapter()
        }


        binding.viewModel = eventListViewModel
        eventListViewModel.onCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onViewCreated(view, savedInstanceState)
    }
}