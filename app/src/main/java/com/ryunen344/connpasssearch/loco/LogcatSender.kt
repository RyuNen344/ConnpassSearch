package com.ryunen344.connpasssearch.loco

import android.util.Log
import com.google.gson.Gson
import com.sys1yagi.loco.core.SendingResult
import com.sys1yagi.loco.core.Sender
import com.sys1yagi.loco.core.internal.SmashedLog

class LogcatSender(gson: Gson) : Sender {

    override suspend fun send(logs: List<SmashedLog>): SendingResult {
        logs.forEach {
            Log.d("LogcatSender", it.toString())
        }
        return SendingResult.SUCCESS
    }

}