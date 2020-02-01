package com.ryunen344.connpasssearch.feature.main.eventList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryunen344.connpasssearch.core.di.ViewModelFactory
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableFragment
import com.ryunen344.connpasssearch.core.ui.behavior.EndlessScrollListener
import com.ryunen344.connpasssearch.feature.main.EventListAdapter
import com.ryunen344.connpasssearch.feature.main.R
import com.ryunen344.connpasssearch.feature.main.databinding.FragmentEventListBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class EventListFragment : LoggingInjectableFragment() {

    private lateinit var binding: FragmentEventListBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var eventListAdapter: EventListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val eventListViewModel: EventListViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentEventListBinding>(
            inflater,
            R.layout.fragment_event_list,
            container,
            false
        )
        binding.lifecycleOwner = this@EventListFragment.viewLifecycleOwner
        binding.viewModel = eventListViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        loadEvent()
    }

    private fun initUI() {
        val layoutManager = LinearLayoutManager(context)

        binding.mainEventList.apply {
            this.layoutManager = layoutManager
            this.adapter = eventListAdapter
            this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            //(this.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            this.addOnScrollListener(object : EndlessScrollListener(layoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    eventListViewModel.loadMoreEventList(currentPage)
                }
            })
        }

        binding.swipeRefresh.apply {
            //            this.setColorSchemeResources(
//                R.color.colorAccent,
//                R.color.colorPrimary,
//                R.color.colorPrimaryDark
//            )
            setOnRefreshListener {
                //                binding.viewModel?.loadEventList()
                isRefreshing = false
            }
        }
    }

    private fun loadEvent() {
        binding.viewModel?.loadEventList()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}
