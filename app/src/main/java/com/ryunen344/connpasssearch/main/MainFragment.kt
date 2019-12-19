package com.ryunen344.connpasssearch.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.util.LogUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    var prevMenuItem: MenuItem? = null
    private lateinit var mSectionsPagerAdapter: MainSectionsPagerAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtil.d()
        var root: View = inflater.inflate(R.layout.fragment_main, container, false)
        setHasOptionsMenu(true)

        //configure timeline_navigation bar
        activity?.let { it ->
            it.navigation.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        view_pager_container.currentItem = 0
                    }
                    R.id.navigation_search -> {
                        view_pager_container.currentItem = 1
                    }
                }
                false
            }
        }


        root.view_pager_container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                LogUtil.d()
                activity?.let {
                    it.toolbar.title = mSectionsPagerAdapter.getPageTitle(position)
                }
            }

            override fun onPageSelected(position: Int) {
                LogUtil.d()

                if (prevMenuItem != null) {
                    prevMenuItem?.isChecked = false
                } else {
                    activity?.let {
                        it.navigation.menu[0].isChecked = false
                        it.toolbar.title = mSectionsPagerAdapter.getPageTitle(0)
                    }
                }

                activity?.let {
                    it.navigation.menu[position].isChecked = true
                    prevMenuItem = it.navigation.menu[position]
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                LogUtil.d()
            }

        })

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onActivityCreated(savedInstanceState)
        mSectionsPagerAdapter = MainSectionsPagerAdapter(fragmentManager!!)
        view_pager_container.adapter = mSectionsPagerAdapter
        view_pager_container.offscreenPageLimit = mSectionsPagerAdapter.count - 1
        activity?.let {
            it.toolbar.title = mSectionsPagerAdapter.getPageTitle(0)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        LogUtil.d()
        super.onViewCreated(view, savedInstanceState)
    }
}