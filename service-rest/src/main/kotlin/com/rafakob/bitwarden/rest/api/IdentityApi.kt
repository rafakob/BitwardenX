package com.rafakob.bitwarden.rest.api

import io.reactivex.Completable

interface IdentityApi {
    fun login(email: String, password: String): Completable
}