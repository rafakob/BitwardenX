package com.rafakob.bitwarden.access.register

import javax.inject.Inject

class RegisterPresenter @Inject constructor(
    private val view: RegisterContract.View
) : RegisterContract.Presenter {
}