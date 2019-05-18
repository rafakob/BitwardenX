package com.rafakob.bitwarden.rest

import com.rafakob.bitwarden.rest.body.PasswordHintBody
import com.rafakob.bitwarden.rest.retrofit.BitwardenApi
import com.rafakob.bitwarden.rest.retrofit.IdentityApi
import com.rafakob.bitwarden.rest.retrofit.VaultApi
import javax.inject.Inject

class RestService @Inject constructor(
    private val bitwardenApi: BitwardenApi,
    private val identityApi: IdentityApi,
    private val vaultApi: VaultApi
) : RestApi {

    override fun passwordHint(email: String) =
        vaultApi.passwordHint("", PasswordHintBody(email = email))
}