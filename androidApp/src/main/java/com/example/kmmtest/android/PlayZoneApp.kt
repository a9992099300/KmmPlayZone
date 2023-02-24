package com.example.kmmtest.android

import PlatformSDK
import android.app.Application
import platform.PlatformConfiguration

class PlayZoneApp : Application( ){

    override fun onCreate() {
        super.onCreate()
        initPlatformSDK()
    }
}

fun PlayZoneApp.initPlatformSDK() =
    PlatformSDK.init(
        config = PlatformConfiguration(context = applicationContext)
    )