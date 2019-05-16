package com.rafakob.bitwarden.startup.passwordhint

import javax.inject.Inject

internal class PasswordHintPresenter @Inject constructor(
    private val view: PasswordHintContract.View
) : PasswordHintContract.Presenter {
}