package com.rafakob.bitwardenx.main

import com.rafakob.bitwardenx.base.BasePresenter

interface MainContract {
    interface View {
        fun showSomething()
    }

    abstract class Presenter : BasePresenter()
}