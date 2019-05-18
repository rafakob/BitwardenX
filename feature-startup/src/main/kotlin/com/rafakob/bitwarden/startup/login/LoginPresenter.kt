package com.rafakob.bitwarden.startup.login

import com.rafakob.bitwarden.startup.navigator.StartupNavigator
import javax.inject.Inject

internal class LoginPresenter @Inject constructor(
    private val view: LoginContract.View,
    var navigator: StartupNavigator
) : LoginContract.Presenter {
}