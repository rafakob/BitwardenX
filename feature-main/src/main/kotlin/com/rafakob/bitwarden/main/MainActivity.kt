package com.rafakob.bitwarden.main

import android.os.Bundle
import com.github.ajalt.timberkt.i
import com.rafakob.bitwarden.base.BaseActivity
import com.rafakob.bitwarden.main.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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