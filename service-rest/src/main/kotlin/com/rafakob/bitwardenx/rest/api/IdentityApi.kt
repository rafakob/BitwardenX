package com.rafakob.bitwardenx.rest.api

import io.reactivex.Completable

interface IdentityApi {
    fun login(email: String, password: String): Completable
}