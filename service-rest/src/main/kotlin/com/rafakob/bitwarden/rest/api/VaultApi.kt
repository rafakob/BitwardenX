package com.rafakob.bitwarden.rest.api

import io.reactivex.Completable

interface VaultApi {
    fun passwordHint(email: String): Completable
}