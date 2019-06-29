package com.ryunen344.connpasssearch.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ryunen344.connpasssearch.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.main.search.SearchFragment
import com.ryunen344.connpasssearch.util.LogUtil

class MainSectionsPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> EventListFragment.newInstance().also {
                //it.mPagerPosition = position
                LogUtil.d()
            }
            else -> SearchFragment.newInstance().also {
                LogUtil.d()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "event list"
            else -> "search"
        }
    }

}