package com.rafakob.bitwarden.splash

import android.os.Bundle
import com.github.ajalt.timberkt.i
import com.rafakob.bitwarden.base.BaseActivity
import com.rafakob.bitwarden.base.Navigator
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onViewAttached()

        navigator.startLogin(this)
    }

    override fun showSomething() {
        i { "View successfully attached!" }
    }

    override fun onDestroy() {
        presenter.onViewDetached()
        super.onDestroy()
    }
}