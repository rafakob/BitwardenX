package com.rafakob.bitwardenx.rest.api

import com.rafakob.bitwardenx.rest.result.PasswordHintResult
import io.reactivex.Single

interface VaultApi {
    fun passwordHint(email: String): Single<PasswordHintResult>
}