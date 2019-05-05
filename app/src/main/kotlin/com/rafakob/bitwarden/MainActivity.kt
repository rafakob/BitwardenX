package com.rafakob.bitwarden

import android.os.Bundle
import com.rafakob.bitwarden.crypto.CryptoApi
import com.rafakob.bitwarden.fragments.LandingFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var cryptoApi: CryptoApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, LandingFragment.newInstance())
//            .commit()
    }
}
