package com.rafakob.bitwardenx.splash

import com.rafakob.bitwardenx.base.BasePresenter

interface SplashContract {
    interface View {
        fun showSomething()
    }

    abstract class Presenter : BasePresenter()
}