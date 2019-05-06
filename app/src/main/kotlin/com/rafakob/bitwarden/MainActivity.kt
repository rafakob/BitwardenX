package com.rafakob.bitwarden

import android.os.Bundle
import com.rafakob.bitwarden.access.AccessContainer
import com.rafakob.bitwarden.access.AccessNavigator
import com.rafakob.bitwarden.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), AccessContainer {

    @Inject
    lateinit var accessNavigator: AccessNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accessNavigator.showLogin()
    }

    override fun accessFragmentManager() = supportFragmentManager

    override fun accessViewContainer() = R.id.container
}
