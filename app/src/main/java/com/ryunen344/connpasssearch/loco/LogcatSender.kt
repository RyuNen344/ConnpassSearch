package com.ryunen344.connpasssearch.loco

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.ryunen344.connpasssearch.util.LogUtil
import com.sys1yagi.loco.core.SendingResult
import com.sys1yagi.loco.sender.JsonArraySender

class LogcatSender(gson: Gson) : JsonArraySender(gson) {
    override suspend fun send(logs: JsonArray): SendingResult {
        logs.forEach {
            LogUtil.d(it.asString)
        }
        return SendingResult.SUCCESS
    }
}