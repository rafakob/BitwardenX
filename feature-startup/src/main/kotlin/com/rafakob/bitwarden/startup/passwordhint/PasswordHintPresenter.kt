package com.rafakob.bitwarden.startup.passwordhint

import com.rafakob.bitwarden.rest.api.VaultApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class PasswordHintPresenter @Inject constructor(
    private val view: PasswordHintContract.View,
    private val vaultApi: VaultApi
) : PasswordHintContract.Presenter {

    override fun onViewAttached() {
        super.onViewAttached()
        vaultApi.passwordHint("vlb@dsa.pl")
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}