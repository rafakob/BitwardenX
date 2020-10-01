package com.rafakob.bitwardenx

import android.content.Context
import com.rafakob.bitwardenx.base.Navigator
import com.rafakob.bitwardenx.main.MainActivity
import com.rafakob.bitwardenx.splash.SplashActivity
import com.rafakob.bitwardenx.startup.StartupActivity
import splitties.activities.start
import javax.inject.Inject

class AppNavigator @Inject constructor() : Navigator {

    override fun startSplash(context: Context) =
        context.start<SplashActivity>()

    override fun startLogin(context: Context) =
        context.start<StartupActivity>()

    override fun startMain(context: Context) =
        context.start<MainActivity>()
}