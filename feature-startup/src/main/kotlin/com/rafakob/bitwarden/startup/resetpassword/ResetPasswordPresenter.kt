package com.rafakob.bitwarden.startup.resetpassword

import javax.inject.Inject

internal class ResetPasswordPresenter @Inject constructor(
    private val view: ResetPasswordContract.View
) : ResetPasswordContract.Presenter {
}