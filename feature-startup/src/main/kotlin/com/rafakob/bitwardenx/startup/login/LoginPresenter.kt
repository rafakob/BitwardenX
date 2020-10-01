package com.rafakob.bitwardenx.startup.login

import com.rafakob.bitwardenx.startup.navigator.StartupNavigator
import javax.inject.Inject

class LoginPresenter @Inject constructor(
        private val view: LoginContract.View,
        private val startupNavigator: StartupNavigator,
        private val loginUseCase: LoginUseCase
) : LoginContract.Presenter() {

    override fun onLoginClick(emailString: String, passwordString: String) {
        loginUseCase.execute(LoginUseCase.Params(emailString.trim(), passwordString))
                .subscribe({ view.startMain() }, { it.printStackTrace() })
                .addToDisposables()
    }

    override fun onRegisterClick() = startupNavigator.showRegister()

    override fun onPasswordHintClick(emailString: String) = startupNavigator.showPasswordHint(emailString.trim())
}