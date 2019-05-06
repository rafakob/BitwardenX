package com.rafakob.bitwarden.access.login

import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val view: LoginContract.View
) : LoginContract.Presenter {
}