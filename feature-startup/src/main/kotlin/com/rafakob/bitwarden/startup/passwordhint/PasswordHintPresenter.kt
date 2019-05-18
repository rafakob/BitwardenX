package com.rafakob.bitwarden.startup.passwordhint

import com.rafakob.bitwarden.rest.RestApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class PasswordHintPresenter @Inject constructor(
    private val view: PasswordHintContract.View,
    private val restApi: RestApi
) : PasswordHintContract.Presenter {

    override fun onViewAttached() {
        super.onViewAttached()
        restApi.passwordHint("vlb@dsa.pl")
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}