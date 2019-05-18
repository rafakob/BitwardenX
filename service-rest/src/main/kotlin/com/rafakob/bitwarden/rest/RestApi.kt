package com.rafakob.bitwarden.rest

import io.reactivex.Completable

interface RestApi {
    fun passwordHint(email: String): Completable
}