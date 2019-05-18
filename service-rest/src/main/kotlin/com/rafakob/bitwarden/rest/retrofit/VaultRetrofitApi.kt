package com.rafakob.bitwarden.rest.retrofit

import com.rafakob.bitwarden.rest.body.PasswordHintBody
import io.reactivex.Completable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

internal interface VaultRetrofitApi {

    @POST("{endpoint}/api/accounts/password-hint")
    fun passwordHint(
        @Path("endpoint", encoded = true) endpoint: String,
        @Body body: PasswordHintBody
    ): Completable
}