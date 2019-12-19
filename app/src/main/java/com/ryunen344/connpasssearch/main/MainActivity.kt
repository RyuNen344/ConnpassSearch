package com.ryunen344.connpasssearch.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.detail.DetailActivity
import com.ryunen344.connpasssearch.detail.DetailActivity.Companion.INTENT_KEY_EVENT_ID
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.main.eventList.EventListNavigator
import com.ryunen344.connpasssearch.main.eventList.EventListViewModel
import com.ryunen344.connpasssearch.main.search.SearchNavigator
import com.ryunen344.connpasssearch.main.search.SearchViewModel
import com.ryunen344.connpasssearch.util.LogUtil
import com.ryunen344.connpasssearch.util.replaceFragmentInActivity
import com.sys1yagi.loco.core.Loco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), EventListNavigator, SearchNavigator {

    companion object {
        private const val REQUEST_CODE = 1
    }

    private val eventListViewModel: EventListViewModel by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d()
        Loco.send(ScreenLog(this::class.java.simpleName))
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        eventListViewModel.setNavigator(this)
        searchViewModel.setNavigator(this)

        var mainFragment: MainFragment? = supportFragmentManager.findFragmentById(mainFrame.id) as MainFragment?
            ?: MainFragment.newInstance().also {
                LogUtil.d()
                replaceFragmentInActivity(supportFragmentManager, it, mainFrame.id)
            }
    }

    override fun onDestroy() {
        eventListViewModel.onActivityDestroyed()
        searchViewModel.onActivityDestroyed()
        super.onDestroy()
    }

    override fun onStartEventDetail(eventId: Int) {
        LogUtil.d("event id = $eventId")
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(INTENT_KEY_EVENT_ID, eventId)
        startActivityForResult(intent, REQUEST_CODE)
    }
}