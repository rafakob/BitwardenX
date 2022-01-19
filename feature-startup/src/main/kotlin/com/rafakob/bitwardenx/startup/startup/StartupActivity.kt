package com.rafakob.bitwardenx.startup.startup

import android.os.Bundle
import com.rafakob.bitwardenx.base.BaseActivity
import com.rafakob.bitwardenx.startup.R
import com.rafakob.bitwardenx.startup.navigator.StartupNavigator
import javax.inject.Inject

class StartupActivity : BaseActivity(), StartupContract.View {

    @Inject
    internal lateinit var presenter: StartupContract.Presenter

    @Inject
    internal lateinit var navigator: StartupNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)
        navigator.showLogin()
    }
}