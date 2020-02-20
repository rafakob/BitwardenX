package com.rafakob.bitwarden.splash

import com.github.ajalt.timberkt.i
import javax.inject.Inject

class SplashPresenter @Inject constructor(
    private val view: SplashContract.View
) : SplashContract.Presenter() {

    override fun onViewAttached() {
        view.showSomething()
    }

    override fun onViewDetached() {
        i { "View detached!" }
    }
}