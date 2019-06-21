package com.ryunen344.connpasssearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.sys1yagi.loco.core.Loco

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Loco.send(ScreenLog(this::class.java.simpleName))
        setContentView(R.layout.activity_main)
    }
}
