package com.rafakob.bitwarden.main

import android.os.Bundle
import com.rafakob.bitwarden.R
import com.rafakob.bitwarden.base.BaseActivity

class MainActivity : BaseActivity(), MainContract.View {

//    @Inject
//    lateinit var accessNavigator: AccessNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        accessNavigator.showLogin()
    }

//    override fun accessFragmentManager() = supportFragmentManager
//
//    override fun accessViewContainer() = R.id.container
}
