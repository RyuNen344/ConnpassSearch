package com.ryunen344.connpasssearch.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ryunen344.connpasssearch.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.main.search.SearchFragment
import com.ryunen344.connpasssearch.util.LogUtil
import javax.inject.Inject

class MainFragmentStateAdapter @Inject constructor(fragment: MainFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> EventListFragment().also {
                LogUtil.d()
            }
            else -> SearchFragment().also {
                LogUtil.d()
            }
        }
    }
}