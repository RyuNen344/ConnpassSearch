package com.ryunen344.connpasssearch.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.util.LogUtil
import com.ryunen344.connpasssearch.util.replaceFragmentInActivity
import com.sys1yagi.loco.core.Loco
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity(), DetailNavigator {

    companion object {
        const val INTENT_KEY_EVENT_ID: String = "key_event_id"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private var eventId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d()
        Loco.send(ScreenLog(this::class.java.simpleName))
        setContentView(R.layout.activity_detail)

        eventId = intent.getIntExtra(INTENT_KEY_EVENT_ID, 0)
        detailViewModel.eventId = eventId

        detailViewModel.setNavigator(this)

        var detailFragment: DetailFragment? = supportFragmentManager.findFragmentById(detailFrame.id) as DetailFragment?
            ?: DetailFragment.newInstance().also {
                LogUtil.d()
                replaceFragmentInActivity(supportFragmentManager, it, detailFrame.id)
            }

    }

    override fun onDestroy() {
        detailViewModel.onActivityDestroyed()
        super.onDestroy()
    }
}