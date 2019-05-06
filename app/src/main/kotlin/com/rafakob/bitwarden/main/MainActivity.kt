package com.rafakob.bitwarden.main

import android.os.Bundle
import com.rafakob.bitwarden.R
import com.rafakob.bitwarden.access.AccessPort
import com.rafakob.bitwarden.base.BaseActivity
import javax.inject.Inject

class MainActivity @Inject constructor() : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    @Inject
    lateinit var accessPort: AccessPort

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewAttached()

        accessPort.initAccessView(supportFragmentManager, R.id.container)
    }
}
