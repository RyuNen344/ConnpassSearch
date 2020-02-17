package com.ryunen344.connpasssearch.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.ryunen344.connpasssearch.core.ui.LoggingInjectableFragment
import com.ryunen344.connpasssearch.feature.main.databinding.FragmentMainBinding
import javax.inject.Inject
import javax.inject.Provider

class MainFragment : LoggingInjectableFragment() {

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var mainFragmentStateAdapterProvider: Provider<MainFragmentStateAdapter>

    // バックキー制御
    private val callback = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            binding.viewPagerContainer.let {
                if (it.currentItem > 0) {
                    it.currentItem = it.currentItem - 1
                }
            }
        }
    }

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
        binding.viewPagerContainer.adapter = mainFragmentStateAdapterProvider.get()

        binding.navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    binding.viewPagerContainer.currentItem = 0
                }
                R.id.navigation_search -> {
                    binding.viewPagerContainer.currentItem = 1
                }
            }
            true
        }

        binding.viewPagerContainer.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.navigation.menu.getItem(position)?.isChecked = true

                // bottom navigationの一番左以外はバックキー制御を有効か
                callback.isEnabled = position > 0
            }
        })
    }

    override fun onDestroyView() {
        binding.viewPagerContainer.adapter = null
        super.onDestroyView()
    }
}
