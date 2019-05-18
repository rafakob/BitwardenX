package com.rafakob.bitwarden.rest

import com.rafakob.bitwarden.rest.body.PasswordHintBody
import com.rafakob.bitwarden.rest.retrofit.BitwardenApi
import com.rafakob.bitwarden.rest.retrofit.IdentityApi
import com.rafakob.bitwarden.rest.retrofit.VaultApi
import com.rafakob.bitwarden.rest.url.UrlProvider
import javax.inject.Inject

class RestService @Inject constructor(
    private val urlProvider: UrlProvider,
    private val bitwardenApi: BitwardenApi,
    private val identityApi: IdentityApi,
    private val vaultApi: VaultApi
) : RestApi {

    override fun passwordHint(email: String) =
        vaultApi.passwordHint(urlProvider.getVaultUrl(), PasswordHintBody(email = email))
}