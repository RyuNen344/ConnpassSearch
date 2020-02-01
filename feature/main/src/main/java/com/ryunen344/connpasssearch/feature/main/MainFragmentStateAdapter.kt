package com.ryunen344.connpasssearch.feature.main

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.ryunen344.connpasssearch.feature.main.eventList.EventListFragment
import com.ryunen344.connpasssearch.feature.main.search.SearchFragment
import javax.inject.Inject

class MainFragmentStateAdapter @Inject constructor(fragment: MainFragment) :
    FragmentStateAdapter(fragment as Fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> EventListFragment()
            else -> SearchFragment()
        }
    }

    override fun onBindViewHolder(
        holder: FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
    }
}
