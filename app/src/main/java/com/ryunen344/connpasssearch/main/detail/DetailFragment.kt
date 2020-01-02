package com.ryunen344.connpasssearch.main.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ryunen344.connpasssearch.BaseFragment
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.databinding.FragmentDetailBinding
import com.ryunen344.connpasssearch.di.viewmodel.ViewModelFactory
import com.ryunen344.connpasssearch.main.eventList.EventListViewModel
import com.ryunen344.connpasssearch.util.LogUtil
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_event_list.*
import javax.inject.Inject

class DetailFragment : BaseFragment(), HasAndroidInjector {

    private lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.d()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = detailViewModel
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onViewCreated(view, savedInstanceState)

        binding.swipeRefresh.apply {
            setOnRefreshListener {
                LogUtil.d()
                isRefreshing = false
            }
        }

        detailViewModel.onCreate()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}