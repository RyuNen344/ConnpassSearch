package com.ryunen344.connpasssearch.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ryunen344.connpasssearch.BaseFragment
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.databinding.FragmentDetailBinding
import com.ryunen344.connpasssearch.di.viewmodel.ViewModelFactory
import com.ryunen344.connpasssearch.util.LogUtil
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailFragment : BaseFragment(), HasAndroidInjector {

    private lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels { viewModelFactory }

    private val args: DetailFragmentArgs by navArgs()

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            LogUtil.d()
            findNavController().navigateUp()
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.d()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = this@DetailFragment.viewLifecycleOwner
        binding.viewModel = detailViewModel
        initToolBar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel?.eventId = args.eventId

        binding.swipeRefresh.apply {
            setOnRefreshListener {
                LogUtil.d()
                isRefreshing = false
            }
        }

        //detailViewModel.onCreate()
    }


    private fun initToolBar() {
        binding.detailToolBar.setupWithNavController(findNavController())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        LogUtil.d()
        return NavigationUI.onNavDestinationSelected(item, findNavController())
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}