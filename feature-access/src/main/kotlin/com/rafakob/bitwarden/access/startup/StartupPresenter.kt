package com.rafakob.bitwarden.access.startup

import javax.inject.Inject

class StartupPresenter @Inject constructor(
    private val view: StartupContract.View
) : StartupContract.Presenter {
}