package com.ryunen344.connpasssearch.application

import android.app.Application
import com.google.gson.Gson
import com.ryunen344.connpasssearch.di.api.ApiModule
import com.ryunen344.connpasssearch.loco.IntervalSendingScheduler
import com.ryunen344.connpasssearch.loco.LogcatSender
import com.ryunen344.connpasssearch.loco.log.ClickLog
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.sys1yagi.loco.core.Loco
import com.sys1yagi.loco.core.LocoConfig
import com.sys1yagi.loco.smasher.FilterableGsonSmasher
import com.sys1yagi.loco.store.android.sqlite.LocoAndroidSqliteStore
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //dependency inject
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            androidFileProperties()
            modules(ApiModule)
        }

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