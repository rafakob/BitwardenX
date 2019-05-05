package com.rafakob.bitwarden

import com.github.ajalt.timberkt.Timber
import com.github.ajalt.timberkt.Timber.DebugTree
import com.rafakob.bitwarden.environment.EnvironmentApi
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject


class BitwardenApplication : DaggerApplication() {

    @Inject
    lateinit var environmentApi: EnvironmentApi

    override fun onCreate() {
        super.onCreate()
        if (environmentApi.isDebuggable()) {
            Timber.plant(DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory()
            .create(this)
    }
}