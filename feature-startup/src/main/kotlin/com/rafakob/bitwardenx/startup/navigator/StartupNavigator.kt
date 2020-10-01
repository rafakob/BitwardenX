package com.rafakob.bitwardenx.startup.navigator

interface StartupNavigator {
    fun showLogin()
    fun showRegister()
    fun showPasswordHint(email: String)
}