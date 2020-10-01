package com.rafakob.bitwarden.rest.api

import com.rafakob.bitwarden.rest.result.PasswordHintResult
import io.reactivex.Single

interface VaultApi {
    fun passwordHint(email: String): Single<PasswordHintResult>
}