package com.ryunen344.connpasssearch.main.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.util.LogUtil
import com.sys1yagi.loco.core.Loco
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val INTENT_KEY_EVENT_ID: String = "key_event_id"
    }

    private val detailViewModel: DetailViewModel by viewModels()
    private var eventId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d()
        Loco.send(ScreenLog(this::class.java.simpleName))
        setContentView(R.layout.activity_detail)

        // set toolbar and actionbar
        toolbar.title = "Event Detail"
        toolbar.setNavigationOnClickListener {
            LogUtil.d()
            onBackPressed()
        }
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        eventId = intent.getIntExtra(INTENT_KEY_EVENT_ID, 0)
        detailViewModel.eventId = eventId

        supportFragmentManager.commit {
            replace(R.id.detailFrame, DetailFragment())
        }
    }

    override fun onDestroy() {
        detailViewModel.onActivityDestroyed()
        super.onDestroy()
    }

    override fun onBackPressed() {
        LogUtil.d()
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        LogUtil.d()
        onBackPressed()
        return true
    }
}