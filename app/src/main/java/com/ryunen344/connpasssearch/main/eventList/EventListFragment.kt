package com.ryunen344.connpasssearch.main.eventList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.ryunen344.connpasssearch.R.layout.fragment_event_list
import com.ryunen344.connpasssearch.behavior.EndlessScrollListener
import com.ryunen344.connpasssearch.databinding.FragmentEventListBinding
import com.ryunen344.connpasssearch.main.EventListAdapter
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.android.synthetic.main.fragment_event_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EventListFragment : Fragment() {

    private lateinit var binding: FragmentEventListBinding
    private val eventListViewModel: EventListViewModel by sharedViewModel()

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
            this.adapter = EventListAdapter(eventListViewModel)
            this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            (this.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            this.addOnScrollListener(object : EndlessScrollListener(layoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    LogUtil.d()
                    eventListViewModel.loadMoreEventList(currentPage)
                }

            })
        }

        swipe_refresh.apply {
            setOnRefreshListener {
                LogUtil.d()
                isRefreshing = false
            }
        }



        binding.viewModel = eventListViewModel
        eventListViewModel.onCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onViewCreated(view, savedInstanceState)
    }
}