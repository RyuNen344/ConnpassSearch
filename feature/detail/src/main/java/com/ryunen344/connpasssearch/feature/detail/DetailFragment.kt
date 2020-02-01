package com.ryunen344.connpasssearch.feature.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ryunen344.connpasssearch.core.di.ViewModelFactory
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableFragment
import com.ryunen344.connpasssearch.feature.detail.databinding.FragmentDetailBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailFragment : LoggingInjectableFragment() {

    private lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels { viewModelFactory }

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            findNavController().navigateUp()
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

//        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = this@DetailFragment.viewLifecycleOwner
        binding.viewModel =
            detailViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.viewModel?.eventId = args.eventId

//        binding.swipeRefresh.apply {
//            setOnRefreshListener {
//                LogUtil.d()
//                isRefreshing = false
//            }
//        }
        initToolBar()

    }


    private fun initToolBar() {
        binding.detailToolBar.setupWithNavController(findNavController())
        binding.detailToolBar.setOnClickListener {
        }
    }
}
