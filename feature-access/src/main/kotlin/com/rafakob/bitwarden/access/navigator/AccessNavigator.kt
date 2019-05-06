package com.rafakob.bitwarden.access.navigator

import androidx.fragment.app.FragmentManager

interface AccessNavigator {
    fun init(fragmentManager: FragmentManager, containerResId: Int)
    fun showStartup()
    fun showLogin()
    fun showRegister()
}