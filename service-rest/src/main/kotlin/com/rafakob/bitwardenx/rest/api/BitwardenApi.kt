package com.rafakob.bitwardenx.rest.api

import io.reactivex.Completable

interface BitwardenApi {
    fun preLogin(email: String): Completable
}