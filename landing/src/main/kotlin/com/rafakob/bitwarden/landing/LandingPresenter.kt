package com.rafakob.bitwarden.landing

import javax.inject.Inject

class LandingPresenter @Inject constructor(
    private val view: LandingContract.View
) : LandingContract.Presenter {
}