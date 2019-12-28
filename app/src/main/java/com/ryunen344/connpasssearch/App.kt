package com.ryunen344.connpasssearch

import android.app.Application
import com.google.gson.Gson
import com.ryunen344.connpasssearch.di.DaggerAppComponent
import com.ryunen344.connpasssearch.loco.IntervalSendingScheduler
import com.ryunen344.connpasssearch.loco.LogcatSender
import com.ryunen344.connpasssearch.loco.log.ClickLog
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.sys1yagi.loco.core.Loco
import com.sys1yagi.loco.core.LocoConfig
import com.sys1yagi.loco.smasher.FilterableGsonSmasher
import com.sys1yagi.loco.store.android.sqlite.LocoAndroidSqliteStore
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        //dependency inject
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)

        //loco start
        Loco.start(
            LocoConfig(
                store = LocoAndroidSqliteStore(this),
                smasher = FilterableGsonSmasher(Gson()),
                senders = mapOf(
                    // log senders and mapping
                    LogcatSender(Gson()) to listOf(
                        ClickLog::class,
                        ScreenLog::class
                    )
                ),
                scheduler = IntervalSendingScheduler(0L),
                extra = LocoConfig.Extra(
                    sendingBulkSize = 30
                )
            )
        )
    }
}