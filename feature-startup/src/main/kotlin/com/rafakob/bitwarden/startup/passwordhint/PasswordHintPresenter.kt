package com.rafakob.bitwarden.startup.passwordhint

import com.rafakob.bitwarden.rest.api.BitwardenApi
import com.rafakob.bitwarden.rest.api.IdentityApi
import com.rafakob.bitwarden.rest.api.VaultApi
import javax.inject.Inject

internal class PasswordHintPresenter @Inject constructor(
    private val view: PasswordHintContract.View,
    private val vaultApi: VaultApi,
    private val bitwardenApi: BitwardenApi,
    private val identityApi: IdentityApi
) : PasswordHintContract.Presenter {

    override fun onViewAttached() {
        super.onViewAttached()
//        vaultApi.passwordHint("test@punto.com")
//            .subscribeOn(Schedulers.io())
//            .subscribe()

//        bitwardenApi.preLogin("test@punto.com")
//            .subscribeOn(Schedulers.io())
//            .subscribe()
    }
}