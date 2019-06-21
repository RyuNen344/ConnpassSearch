package com.ryunen344.connpasssearch.application

import android.app.Application
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.ryunen344.connpasssearch.loco.LogcatSender
import com.ryunen344.connpasssearch.loco.log.ClickLog
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.sys1yagi.loco.core.*
import com.sys1yagi.loco.core.internal.SmashedLog
import com.sys1yagi.loco.smasher.FilterableGsonSmasher
import com.sys1yagi.loco.store.android.sqlite.LocoAndroidSqliteStore
import kotlinx.coroutines.delay
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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