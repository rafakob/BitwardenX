package com.rafakob.bitwarden.startup.login

import com.rafakob.bitwarden.base.BasePresenter

interface LoginContract {
    interface View {
        fun startMain()
    }

    abstract class Presenter : BasePresenter() {
        abstract fun onLoginClick(emailString: String, passwordString: String)
        abstract fun onRegisterClick()
        abstract fun onPasswordHintClick(emailString: String)
    }
}