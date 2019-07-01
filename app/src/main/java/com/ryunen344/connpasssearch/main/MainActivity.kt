package com.ryunen344.connpasssearch.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.main.eventList.EventListNavigator
import com.ryunen344.connpasssearch.main.eventList.EventListViewModel
import com.ryunen344.connpasssearch.util.LogUtil
import com.ryunen344.connpasssearch.util.replaceFragmentInActivity
import com.sys1yagi.loco.core.Loco
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), EventListNavigator {

    private val eventListViewModel: EventListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d()
        Loco.send(ScreenLog(this::class.java.simpleName))
        setContentView(R.layout.activity_main)

        eventListViewModel.setNavigator(this)

        var mainFragment: MainFragment? = supportFragmentManager.findFragmentById(mainFrame.id) as MainFragment?
            ?: MainFragment.newInstance().also {
                LogUtil.d()
                replaceFragmentInActivity(supportFragmentManager, it, mainFrame.id)
            }
    }

    override fun onDestroy() {
        eventListViewModel.onActivityDestroyed()
        super.onDestroy()
    }

    override fun onStartEventDetail(eventId: Int) {
        LogUtil.d("activityで拾えないいい言いいいいい言い!!!!!!！！！！！！！！！！！！！！！！！")
        LogUtil.d("event id = $eventId")
    }

}