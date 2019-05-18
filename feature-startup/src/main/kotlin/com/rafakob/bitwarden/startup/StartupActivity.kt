package com.rafakob.bitwarden.startup

import android.os.Bundle
import com.rafakob.bitwarden.base.BaseActivity
import com.rafakob.bitwarden.startup.navigator.StartupNavigator
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