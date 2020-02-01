package com.ryunen344.connpasssearch.feature.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableFragment
import com.ryunen344.connpasssearch.feature.main.databinding.FragmentMainBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : LoggingInjectableFragment() {

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var mainFragmentStateAdapter: MainFragmentStateAdapter

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
        initToolBar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
    }

    private fun initToolBar() {
        binding.mainToolBar.setupWithNavController(findNavController())
    }

    private fun initViewPager() {
        binding.viewPagerContainer.adapter = mainFragmentStateAdapter

        binding.navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    binding.viewPagerContainer.currentItem = 0
                }
                R.id.navigation_search -> {
                    binding.viewPagerContainer.currentItem = 1
                }
            }
            false
        }

        binding.viewPagerContainer.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {

//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                LogUtil.d()
//                activity?.let {
//                    it.toolbar.title = mSectionsPagerAdapter.getPageTitle(position)
//                }
//            }
//
//            override fun onPageSelected(position: Int) {
//                LogUtil.d()
//
//                if (prevMenuItem != null) {
//                    prevMenuItem?.isChecked = false
//                } else {
//                    activity?.let {
//                        it.navigation.menu[0].isChecked = false
//                        it.toolbar.title = mSectionsPagerAdapter.getPageTitle(0)
//                    }
//                }
//
//                activity?.let {
//                    it.navigation.menu[position].isChecked = true
//                    prevMenuItem = it.navigation.menu[position]
//                }
//            }

            override fun onLayoutChange(
                v: View?,
                left: Int,
                top: Int,
                right: Int,
                bottom: Int,
                oldLeft: Int,
                oldTop: Int,
                oldRight: Int,
                oldBottom: Int
            ) {
            }
        }

        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController())
    }

}
