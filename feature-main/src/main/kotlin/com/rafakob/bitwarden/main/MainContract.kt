package com.rafakob.bitwarden.main

import com.rafakob.bitwarden.base.BasePresenter

interface MainContract {
    interface View {
        fun showSomething()
    }

    abstract class Presenter : BasePresenter()
}