package com.rafakob.bitwarden.main

import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View
) : MainContract.Presenter {
}