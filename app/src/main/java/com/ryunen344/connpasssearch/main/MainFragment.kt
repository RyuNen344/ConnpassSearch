package com.ryunen344.connpasssearch.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ryunen344.connpasssearch.BaseFragment
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.databinding.FragmentMainBinding
import com.ryunen344.connpasssearch.util.LogUtil
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : BaseFragment(), HasAndroidInjector {

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var mainSectionsPagerAdapter: MainSectionsPagerAdapter
    var prevMenuItem: MenuItem? = null

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this@MainFragment.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPagerContainer.adapter = mainSectionsPagerAdapter
        LogUtil.d()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}