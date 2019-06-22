package com.ryunen344.connpasssearch.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryunen344.connpasssearch.R
import com.ryunen344.connpasssearch.loco.log.ClickLog
import com.ryunen344.connpasssearch.loco.log.ScreenLog
import com.ryunen344.connpasssearch.util.LogUtil
import com.sys1yagi.loco.core.Loco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d()
        Loco.send(ScreenLog(this::class.java.simpleName))
        setContentView(R.layout.activity_main)

        var i = 0
        hello_text.setOnClickListener {
            LogUtil.d()
            Loco.send(ClickLog("click $i"))
            i++
        }
    }
}
