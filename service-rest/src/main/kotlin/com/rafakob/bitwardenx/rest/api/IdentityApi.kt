package com.rafakob.bitwardenx.rest.api

import com.rafakob.bitwardenx.rest.result.LoginResult
import io.reactivex.Single

interface IdentityApi {
    fun login(email: String, password: String): Single<LoginResult>
}