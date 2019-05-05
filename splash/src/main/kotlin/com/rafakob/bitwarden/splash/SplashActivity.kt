package com.rafakob.bitwarden.splash

import android.os.Bundle
import com.github.ajalt.timberkt.i
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onViewAttached()
    }

    override fun showSomething() {
        i { "View successfully attached!" }
    }

    override fun onDestroy() {
        presenter.onViewDetached()
        super.onDestroy()
    }
}