package com.ryunen344.connpasssearch.feature.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableFragment
import com.ryunen344.connpasssearch.feature.main.R
import com.ryunen344.connpasssearch.feature.main.databinding.FragmentSearchBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

class SearchFragment : LoggingInjectableFragment() {

    private val job = SupervisorJob()
    private val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val layoutManager = LinearLayoutManager(context)

//        main_event_list.apply {
//            this.layoutManager = layoutManager
//            this.setHasFixedSize(true)
//            //this.adapter = SearchAdapter(searchViewModel)
//            this.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
//            (this.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
//            this.addOnScrollListener(object : EndlessScrollListener(layoutManager) {
//                override fun onLoadMore(currentPage: Int) {
//                    //searchViewModel.loadMoreEventList(currentPage)
//                }
//
//            })
//        }
//
//        swipe_refresh.apply {
//            setOnRefreshListener {
//                isRefreshing = false
//            }
//        }

//        searchViewModel.keyword.observe(this.viewLifecycleOwner, Observer {
//            if (it.isNotEmpty()) {
////                launch {
////                    delay(5000)
////                    LogUtil.d("keyword is $it")
////                    searchViewModel.searchEvent(it)
////                }
//                searchViewModel.searchEvent(it)
//            } else {
//                searchViewModel.clearEvent()
//            }
//        })

        //binding.viewModel = searchViewModel
        //searchViewModel.onCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineContext.cancelChildren()
    }


}
