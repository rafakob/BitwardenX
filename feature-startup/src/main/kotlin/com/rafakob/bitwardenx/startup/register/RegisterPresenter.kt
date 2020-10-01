package com.rafakob.bitwardenx.startup.register

import javax.inject.Inject

internal class RegisterPresenter @Inject constructor(
    private val view: RegisterContract.View
) : RegisterContract.Presenter() {
}