package com.network.app

import android.app.Application
import services.vego.network.Initialize

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        /**  Set base url and headers for api */
//        Initialize.networkConfig("https://...", getHeaderMap())
        Initialize.networkConfig("https://apps.wattak.com/", getHeaderMap())
    }

    private fun getHeaderMap(): HashMap<String, String> {
        val headerMap = HashMap<String, String>()
        /** if you want add header */

        headerMap["Authorization"] =
            "Bearer ..."
        return headerMap
    }
}