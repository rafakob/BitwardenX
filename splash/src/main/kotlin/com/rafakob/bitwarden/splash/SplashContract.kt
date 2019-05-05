package com.rafakob.bitwarden.splash

import com.rafakob.bitwarden.base.BasePresenter

interface SplashContract {
    interface View {
        fun showSomething()
    }

    interface Presenter : BasePresenter
}