package com.rafakob.bitwardenx.startup.navigator

internal interface StartupNavigator {
    fun showLogin()
    fun showRegister()
    fun showPasswordHint(email: String)
}