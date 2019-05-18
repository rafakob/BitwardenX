package com.rafakob.bitwarden.rest.api

import com.rafakob.bitwarden.rest.body.PasswordHintBody
import com.rafakob.bitwarden.rest.retrofit.VaultRetrofitApi
import com.rafakob.bitwarden.rest.url.UrlProvider
import retrofit2.Retrofit
import javax.inject.Inject

class VaultService @Inject constructor(
    private val urlProvider: UrlProvider,
    private val retrofit: Retrofit
) : VaultApi {

    private val api: VaultRetrofitApi by lazy { retrofit.create(VaultRetrofitApi::class.java) }

    override fun passwordHint(email: String) =
        api.passwordHint(urlProvider.getVaultUrl(), PasswordHintBody(email = email))
}