package com.rafakob.bitwarden.startup.navigator

interface StartupNavigator {
    fun showLogin()
    fun showRegister()
    fun showPasswordHint(email: String)
}