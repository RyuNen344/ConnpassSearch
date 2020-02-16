package com.ryunen344.connpasssearch.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableFragment
import com.ryunen344.connpasssearch.feature.main.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : LoggingInjectableFragment() {

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var mainFragmentStateAdapter: MainFragmentStateAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false).also {
            it.lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar()
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
}
