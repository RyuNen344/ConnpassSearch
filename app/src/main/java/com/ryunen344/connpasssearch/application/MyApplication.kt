package com.ryunen344.connpasssearch.application

import android.app.Application
import com.google.gson.Gson
import com.ryunen344.connpasssearch.loco.IntervalSendingScheduler
import com.ryunen344.connpasssearch.loco.LogcatSender
import com.ryunen344.connpasssearch.loco.log.ClickLog
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.sys1yagi.loco.core.Loco
import com.sys1yagi.loco.core.LocoConfig
import com.sys1yagi.loco.smasher.FilterableGsonSmasher
import com.sys1yagi.loco.store.android.sqlite.LocoAndroidSqliteStore

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
//        debugLog("start")
//
//        //init db
//        AccountDatabase.init(this)
//
//        //dependency inject
//        startKoin {
//            androidLogger(Level.DEBUG)
//            androidContext(this@MyApplication)
//            androidFileProperties()
//            modules(AppModule, UtilModule, ApiModule)
//        }
//
//        debugLog("end")

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
                scheduler = IntervalSendingScheduler(3000L),
                extra = LocoConfig.Extra(
                    sendingBulkSize = 30
                )
            )
        )
    }


}