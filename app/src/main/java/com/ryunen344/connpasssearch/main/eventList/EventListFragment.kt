package com.ryunen344.connpasssearch.main.eventList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.SimpleItemAnimator
import com.ryunen344.connpasssearch.BaseFragment
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.behavior.EndlessScrollListener
import com.ryunen344.connpasssearch.databinding.FragmentEventListBinding
import com.ryunen344.connpasssearch.di.viewmodel.ViewModelFactory
import com.ryunen344.connpasssearch.main.EventListAdapter
import com.ryunen344.connpasssearch.util.LogUtil
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class EventListFragment : BaseFragment(), HasAndroidInjector {

    private lateinit var binding: FragmentEventListBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var eventListAdapter: EventListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var eventListViewModel: EventListViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        eventListViewModel = ViewModelProvider(this, viewModelFactory).get(EventListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.d()
        binding = DataBindingUtil.inflate<FragmentEventListBinding>(
            inflater,
            R.layout.fragment_event_list,
            container,
            false)
        binding.lifecycleOwner = this@EventListFragment.viewLifecycleOwner
        binding.viewModel = eventListViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val layoutManager = LinearLayoutManager(context)

        binding.mainEventList.apply {
            this.layoutManager = layoutManager
            this.adapter = eventListAdapter
            this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            (this.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            this.addOnScrollListener(object : EndlessScrollListener(layoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    LogUtil.d()
                    eventListViewModel.loadMoreEventList(currentPage)
                }
            })
        }

        binding.swipeRefresh.apply {
            setOnRefreshListener {
                LogUtil.d()
                isRefreshing = false
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}