package com.rafakob.bitwardenx.startup.login

import com.rafakob.bitwardenx.base.BasePresenter

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