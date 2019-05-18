package com.rafakob.bitwarden.startup.navigator

internal interface StartupNavigator {
    fun showLogin()
    fun showRegister()
    fun showPasswordHint(email: String)
}