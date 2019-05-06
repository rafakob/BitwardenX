package com.rafakob.bitwarden.main

import android.os.Bundle
import com.rafakob.bitwarden.R
import com.rafakob.bitwarden.access.AccessContainer
import com.rafakob.bitwarden.access.startup.StartupFragment
import com.rafakob.bitwarden.base.BaseActivity
import javax.inject.Inject

class MainActivity @Inject constructor() : BaseActivity(), MainContract.View, AccessContainer {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewAttached()
        replaceInAccessContainer()
    }

    override fun replaceInAccessContainer() {
        accessFragmentManager().beginTransaction().replace(accessViewContainer(), StartupFragment.newInstance())
            .commit()
    }

    override fun accessFragmentManager() = supportFragmentManager

    override fun accessViewContainer() = R.id.container
}
