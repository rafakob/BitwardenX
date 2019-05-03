package com.rafakob.bitwarden

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BitwardenApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory()
            .create(this)
    }
}