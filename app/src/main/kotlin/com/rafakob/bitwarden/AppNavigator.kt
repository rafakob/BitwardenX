package com.rafakob.bitwarden

import android.content.Context
import com.rafakob.bitwarden.base.Navigator
import com.rafakob.bitwarden.main.MainActivity
import com.rafakob.bitwarden.splash.SplashActivity
import com.rafakob.bitwarden.startup.StartupActivity
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class AppNavigator @Inject constructor() : Navigator {

    override fun startSplash(context: Context) {
        context.startActivity<SplashActivity>()
    }

    override fun startLogin(context: Context) {
        context.startActivity<StartupActivity>()
    }

    override fun startMain(context: Context) {
        context.startActivity<MainActivity>()
    }
}