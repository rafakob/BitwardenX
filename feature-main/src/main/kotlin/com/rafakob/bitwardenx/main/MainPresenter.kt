package com.rafakob.bitwardenx.main

import com.github.ajalt.timberkt.i
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View
) : MainContract.Presenter() {

    override fun onViewAttached() {
        view.showSomething()
    }

    override fun onViewDetached() {
        i { "View detached!" }
    }
}