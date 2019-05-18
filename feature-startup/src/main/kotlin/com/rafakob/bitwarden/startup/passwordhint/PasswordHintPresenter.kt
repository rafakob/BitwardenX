package com.rafakob.bitwarden.startup.passwordhint

import com.rafakob.bitwarden.rest.RestApi
import javax.inject.Inject

internal class PasswordHintPresenter @Inject constructor(
    private val view: PasswordHintContract.View,
    private val restApi: RestApi
) : PasswordHintContract.Presenter {
}