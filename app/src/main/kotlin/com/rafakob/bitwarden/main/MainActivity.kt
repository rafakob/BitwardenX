package com.rafakob.bitwarden.main

import android.os.Bundle
import com.rafakob.bitwarden.R
import com.rafakob.bitwarden.startup.StartupActivity
import com.rafakob.bitwarden.base.BaseActivity
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity @Inject constructor() : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewAttached()

        startActivity<StartupActivity>()
    }
}
