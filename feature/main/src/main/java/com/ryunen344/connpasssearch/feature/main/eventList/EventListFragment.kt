package com.ryunen344.connpasssearch.feature.main.eventList

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.google.android.material.snackbar.Snackbar
import com.ryunen344.connpasssearch.core.di.ViewModelFactory
import com.ryunen344.connpasssearch.core.ext.isShow
import com.ryunen344.connpasssearch.core.ext.stringRes
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableFragment
import com.ryunen344.connpasssearch.core.ui.behavior.EndlessScrollListener
import com.ryunen344.connpasssearch.core.ui.transition.Stagger
import com.ryunen344.connpasssearch.feature.main.EventListAdapter
import com.ryunen344.connpasssearch.feature.main.MainFragmentDirections
import com.ryunen344.connpasssearch.feature.main.databinding.FragmentEventListBinding
import com.ryunen344.connpasssearch.model.AppError
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class EventListFragment : LoggingInjectableFragment() {

    private lateinit var binding: FragmentEventListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val eventListViewModel: EventListViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventListBinding.inflate(inflater, container, true).also {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = eventListViewModel
        }

        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        loadEvent()
    }

    @ExperimentalCoroutinesApi
    private fun initUI() {

        val adapter = EventListAdapter {
            val directionsToDetailFragment = MainFragmentDirections.actionToDetail(it.eventId)
            parentFragment?.findNavController()?.navigate(directionsToDetailFragment)
        }

        binding.mainEventList.apply {
            this.adapter = adapter
            //(this.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            addOnScrollListener(object :
                EndlessScrollListener(layoutManager as LinearLayoutManager) {
                override fun onLoadMore(currentPage: Int) {
                    //eventListViewModel.loadMoreEventList(currentPage)
                }
            })

            itemAnimator = object : DefaultItemAnimator() {
                override fun animateAdd(holder: RecyclerView.ViewHolder?): Boolean {
                    dispatchAddFinished(holder)
                    dispatchAddStarting(holder)
                    return false
                }
            }

            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.top = 6
                    outRect.left = 6
                    outRect.right = 6
                    outRect.bottom = 6
                }
            })
        }

        binding.progressBar.show()
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

        val stagger = Stagger()
        eventListViewModel.uiModel.observe(viewLifecycleOwner) { uiModel ->
            binding.progressBar.isShow = uiModel.isLoading

            TransitionManager.beginDelayedTransition(binding.mainEventList, stagger)
            adapter.submitList(uiModel.eventList)

            uiModel.error?.let {
                showErrorSnackbar(
                    binding.mainEventList,
                    it,
                    true
                )
            }
        }
    }

    private fun loadEvent() {
        binding.viewModel?.loadEventList()
    }

    private fun showErrorSnackbar(view: View, appError: AppError, showRetryAction: Boolean) {
        Snackbar.make(
            view,
            appError.stringRes(),
            Snackbar.LENGTH_LONG
        ).apply {
            if (showRetryAction) {
                setAction("R.string.retry_label") {
                    //contributorsViewModel.onRetry()
                }
            }
        }.show()
    }
}
