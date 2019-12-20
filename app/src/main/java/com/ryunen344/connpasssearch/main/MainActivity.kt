package com.ryunen344.connpasssearch.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.commit
import com.ryunen344.connpasssearch.BaseActivity
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.detail.DetailActivity
import com.ryunen344.connpasssearch.detail.DetailActivity.Companion.INTENT_KEY_EVENT_ID
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.main.eventList.EventListNavigator
import com.ryunen344.connpasssearch.main.search.SearchNavigator
import com.ryunen344.connpasssearch.util.LogUtil
import com.sys1yagi.loco.core.Loco
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), EventListNavigator, SearchNavigator, HasAndroidInjector {

    companion object {
        private const val REQUEST_CODE = 1
    }

    @Inject
    lateinit var fragmentInjector : DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        Loco.send(ScreenLog(this::class.java.simpleName))
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            replace(R.id.main_fragment_container, MainFragment())
        }
    }

    override fun onStartEventDetail(eventId: Int) {
        LogUtil.d("event id = $eventId")
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(INTENT_KEY_EVENT_ID, eventId)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector
}